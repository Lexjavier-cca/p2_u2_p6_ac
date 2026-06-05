package ec.edu.uce.infraestrucure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repositoy.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

public class ProfesorRepositoryImpl implements ProfesorRepository {
    @Inject
    private EntityManager em; 
    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
        
    }

    @Override
    public Profesor seleccionarPorId(Integer id) {
        
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        this.em.merge(profesor);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
    }

    @Override
    public List<Profesor> seleccionarPorAsignatura(String asignatura) {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.asignatura = :asignatura", Profesor.class);
        query.setParameter("asignatura", asignatura);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorCorreo(String dominio) {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.correo LIKE :dominio", Profesor.class);
        query.setParameter("dominio", "%" + dominio );
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorCedulaPichinchaOGuayas() {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula LIKE '17%' OR p.cedula LIKE '09%'", Profesor.class);
        return query.getResultList();
    }

    @Override
    public List<Profesor> buscarPorCedulaPichincha() {
        Query query = this.em.createNamedQuery("Profesor.buscarPorCedulaPichincha", Profesor.class);
        return query.getResultList();
    }

    @Override
    public Long contarProfesoresCalculo() {
        Query query = this.em.createNamedQuery("Profesor.contarProfesoresCalculo", Long.class);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<Profesor> buscarPorCorreoInstitucional() {
        Query query = this.em.createNamedQuery("Profesor.buscarPorCorreoInstitucional", Profesor.class);
        return query.getResultList();
    }

    @Override
    public List<Profesor> buscarPorGeneroFemenino() {
        Query query = this.em.createNamedQuery("Profesor.buscarPorGeneroFemenino", Profesor.class);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarTodosNative() {
        Query query = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
        return (List<Profesor>) query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorRangodeFechadeNacimiento(LocalDate inicio, LocalDate fin) {
        Query query = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_fecha_nacimiento BETWEEN :inicio AND :fin", Profesor.class);
        query.setParameter("inicio", inicio);
        query.setParameter("fin", fin);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorCedulaGuayasyTelefono(Integer fin) {
        Query query = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_cedula LIKE '09%' AND prof_telefono LIKE :fin", Profesor.class);
        query.setParameter("fin", "%" + fin);
        return  (List<Profesor>)query.getResultList();
    }

    @Override
    public Long contarProfesoresConIDMayorA(Integer id) {
        Query query = this.em.createNativeQuery("SELECT COUNT(*) FROM profesor WHERE prof_id > :id");
        query.setParameter("id", id);
        return (Long) query.getSingleResult();
    }

    @Override
    public List<Profesor> seleccionarTodosCriteria() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> cq = cb.createQuery(Profesor.class);
        Root<Profesor> root = cq.from(Profesor.class);
        cq.select(root);
        TypedQuery<Profesor> query = this.em.createQuery(cq);
        return query.getResultList();

    }

    @Override
    public List<Profesor> buscarPorApellido(String apellido) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> cq = cb.createQuery(Profesor.class);
        Root<Profesor> root = cq.from(Profesor.class);
        Predicate p1 = cb.equal(root.get("apellido"), apellido);
        cq.select(root).where(p1);
        TypedQuery<Profesor> miQuery = this.em.createQuery(cq);
        return miQuery.getResultList();
         
    }

    @Override
    public List<Profesor> seleccionarPorEdad(Integer edad) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> cq = cb.createQuery(Profesor.class);
        Root<Profesor> root = cq.from(Profesor.class);
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaFin = fechaActual.minusYears(edad);
        LocalDate fechaInicio = fechaActual.minusYears(edad +1).plusDays(1);
        Predicate p1 = cb.between(root.get("fechaNacimiento"), fechaInicio ,fechaFin);
        cq.select(root).where(p1);
        TypedQuery<Profesor> query = this.em.createQuery(cq);
        return query.getResultList();
    }

}
