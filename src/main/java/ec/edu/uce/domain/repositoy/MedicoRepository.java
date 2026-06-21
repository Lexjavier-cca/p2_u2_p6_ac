package ec.edu.uce.domain.repositoy;
import ec.edu.uce.domain.model.Medico;
public interface MedicoRepository{
    public void insertar(Medico medico);
    public Medico seleccionarPorId(Integer id);
}
