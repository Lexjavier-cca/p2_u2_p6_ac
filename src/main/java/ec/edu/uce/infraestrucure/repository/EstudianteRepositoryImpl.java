package ec.edu.uce.infraestrucure.repository;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repositoy.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    //1.2 named query

}
