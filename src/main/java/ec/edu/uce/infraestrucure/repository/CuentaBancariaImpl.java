package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repositoy.CuentaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaImpl implements CuentaBancariaRepository{
    @Inject
    private EntityManager em;
    @Override
    public void insertar(CuentaBancaria cuenta) {
        // TODO Auto-generated method stub
        this.em.persist(cuenta);
    }

}
