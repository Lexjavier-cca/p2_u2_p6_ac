package ec.edu.uce.domain.repositoy;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {
    public void crear(Estudiante estudiante);
    public Estudiante seleccionarPorId(Integer id);
    public void actualizar(Estudiante estudiante);
    public void eliminar(Integer id);


}
