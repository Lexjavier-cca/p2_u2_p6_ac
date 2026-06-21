package ec.edu.uce.infraestrucure.repository;
import ec.edu.uce.domain.model.Medico;
import ec.edu.uce.domain.repositoy.MedicoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class MedicoRepositoryImpl implements MedicoRepository {
    @Inject
    private EntityManager em;
    @Override
    public void insertar(Medico medico) {
        this.em.persist(medico);
    }

    @Override
    public Medico seleccionarPorId(Integer id) {
        return this.em.find(Medico.class,id);
    }

}
