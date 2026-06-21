package ec.edu.uce.domain.repositoy;
import ec.edu.uce.domain.model.Paciente;
public interface PacienteRepository {
    public void insertar(Paciente paciente);
    public Paciente seleccionarPorId(Integer id);
}
