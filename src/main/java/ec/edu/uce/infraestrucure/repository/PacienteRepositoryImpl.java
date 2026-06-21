package ec.edu.uce.infraestrucure.repository;
import ec.edu.uce.domain.model.Paciente;
import ec.edu.uce.domain.repositoy.PacienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{
    @Inject
    private EntityManager em;

    @Override
    public void insertar(Paciente paciente) {
        this.em.persist(paciente);
    }

    @Override
    public Paciente seleccionarPorId(Integer id) {
        return this.em.find(Paciente.class,id);
    }

}
