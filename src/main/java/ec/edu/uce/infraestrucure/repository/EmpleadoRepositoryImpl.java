package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repositoy.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

public class EmpleadoRepositoryImpl implements EmpleadoRepository{
    @Inject
    private EntityManager em;
    
    @Override
    public void insertar(Empleado empleado) {
        // TODO Auto-generated method stub
        this.em.persist(empleado);;
    }

}
