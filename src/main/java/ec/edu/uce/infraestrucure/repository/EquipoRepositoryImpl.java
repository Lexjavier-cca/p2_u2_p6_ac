package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Equipo;
import ec.edu.uce.domain.repositoy.EquipoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EquipoRepositoryImpl implements EquipoRepository{
    @Inject
    private EntityManager em;
    
    @Override
    public void insertar(Equipo equipo) {
        this.em.persist(equipo);
    }
    
}