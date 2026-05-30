package ec.edu.uce.infraestrucure.repository;

import java.time.LocalDate;
import java.util.List;



import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repositoy.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
    


}
