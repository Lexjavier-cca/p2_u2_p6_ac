package ec.edu.uce.infraestrucure.repository;

import ec.edu.uce.domain.model.Contrato;
import ec.edu.uce.domain.repositoy.ContratoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ContratoRepositoryImpl implements ContratoRepository {
    @Inject
    private EntityManager em;
    @Override
    public void crear(Contrato contrato) {
        this.em.persist(contrato);
    }

}
