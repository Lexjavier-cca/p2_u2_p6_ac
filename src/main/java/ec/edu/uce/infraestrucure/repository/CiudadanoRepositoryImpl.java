package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repositoy.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class CiudadanoRepositoryImpl implements CiudadanoRepository{
    @Inject
    private EntityManager em;
    
    @Override
    public void crear(Ciudadano ciudadano) {
        // TODO Auto-generated method stub
        this.em.persist(ciudadano);
    }


}
