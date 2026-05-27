package ec.edu.uce.domain.repositoy;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {
    public void crear(Profesor profesor);
    public Profesor seleccionarPorId(Integer id);
    public void actualizar(Profesor profesor);
    public void eliminar(Integer id);
    public List<Profesor> seleccionarPorAsignatura(String asignatura);
    public List<Profesor> seleccionarPorCorreo(String dominio);
    public List<Profesor> seleccionarPorCedulaPichinchaOGuayas();
}
