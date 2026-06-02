package ec.edu.uce.infraestrucure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repositoy.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{
    @Inject
    private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
      this.em.persist(estudiante);
    }

    @Override
    public Estudiante seleccionarPorId(Integer id) {
       return this.em.find(Estudiante.class, id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.em.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
        
    }
        //1 Query
    //1.1 typed query
    //
    @Override
    public List<Estudiante> seleccionarTodos() {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return miQuery.getResultList();
    }
    @Override
    public List<Estudiante> seleccionarPorNombre(String nombre) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre=:nombre1", Estudiante.class);
        miQuery.setParameter("nombre1", nombre);
        return miQuery.getResultList();
    }
    @Override
    public Estudiante seleccionarPorCedula(String cedula) {
        TypedQuery<Estudiante> miQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula", Estudiante.class);
        miQuery.setParameter("cedula", cedula);
        //return miQuery.getSingleResult();
        //return miQuery.getResultList().get(0);
        //return miQuery.getResultList().getLast();
        return miQuery.getResultList().getFirst();
    

    }
    //1.2 Named Query
     @Override
    public List<Estudiante> seleccionarPorGenero(String genero) {
        Query miQuery = (Query) this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        miQuery.setParameter("genero", genero);
        return (List<Estudiante>) miQuery.getResultList();
    }

     @Override
    public List<Estudiante> seleccionarPorGeneroTyped(String genero) {
        // TODO Auto-generated method stub
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        miQuery.setParameter("genero", genero);
        return miQuery.getResultList();
     }

     @Override
    public List<Estudiante> seleccionarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> miQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        miQuery.setParameter("inicio", fechaInicio);
        miQuery.setParameter("fin", fechaFin);
        return miQuery.getResultList();
     }
     @Override
    public Long seleccionarContar() {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Estudiante.contarPorRangoFecha", Long.class);
        return miQuery.getSingleResult();
    }

     
    //2 Native Query
    @Override
    @SuppressWarnings("unchecked")
     public List<Estudiante> seleccionarTodosNative() {
        Query miQuery = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
        return (List<Estudiante>) miQuery.getResultList();
     }
    
      //3 Criteria API Query
    @Override
    public List<Estudiante> seleccionarTodosCriteria() {
        //crear instancia que va a ser la encargada de esta construccion
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        //defininr el tipo de objeto que va a retornar la consulta
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        //se define las entidades del FROM
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        //definir con que tipo de sql voy a trabajar: Select en este caso
        myQuery.select(root);
        //hasta aquí se ha construido la query
        
        //trasnformar myQuery a un query ejecutable
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();
    }
    @Override
    public List<Estudiante> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        //equal 1 que voy a compararar
        // contra que voy a compaarar
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        myQuery.select(root).where(p1);
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();
    }
    @Override
    public List<Estudiante> seleccionarDinamicoCriteria(String nombre, String apellido){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        List<Predicate> condiciones = new ArrayList<>();
        if(nombre!=null){
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }if(apellido!=null){
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }
        myQuery.select(root).where(condiciones);
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

}
