package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repositoy.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteRepositoryImpl implements ClienteRepository{
    @Inject
    private EntityManager em;
    
    @Override
    public void crear(Cliente cliente) {
        // TODO Auto-generated method stub
        this.em.persist(cliente);;
    }

}
