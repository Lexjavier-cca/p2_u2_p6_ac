package ec.edu.uce.infraestrucure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repositoy.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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

}
