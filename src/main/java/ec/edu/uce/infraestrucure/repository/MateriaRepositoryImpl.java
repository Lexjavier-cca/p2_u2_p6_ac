package ec.edu.uce.infraestrucure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repositoy.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository {
    @Inject
    private EntityManager em;
    @Override
    public void insertar(Materia materia) {
        // TODO Auto-generated method stub
        this.em.persist(materia);
    }
    @Override
    public Materia seleccionarPorId(Integer id) {
        // TODO Auto-generated method stub
        return this.em.find(Materia.class, id);
    }

}
