package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repositoy.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoRepositoryImpl implements AlumnoRepository {
    @Inject
    private EntityManager em;

    @Override
    public void insertar(Alumno alumno) {
        // TODO Auto-generated method stub
        this.em.persist(alumno);;
    }

    @Override
    public Alumno consultarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.em.find(Alumno.class, id);
    }
}
