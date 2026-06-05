package ec.edu.uce.domain.repositoy;

import java.time.LocalDate;
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
    public List<Profesor> buscarPorCedulaPichincha();
    public Long contarProfesoresCalculo();
    public List<Profesor> buscarPorCorreoInstitucional();
    public List<Profesor> buscarPorGeneroFemenino();
    public List<Profesor> seleccionarTodosNative();
    public List<Profesor> seleccionarPorRangodeFechadeNacimiento(LocalDate inicio, LocalDate fin);
    public List<Profesor> seleccionarPorCedulaGuayasyTelefono(Integer fin);
    public Long contarProfesoresConIDMayorA(Integer id);
    public List<Profesor> seleccionarTodosCriteria();
    public List<Profesor> buscarPorApellido(String apellido);
    public List<Profesor> seleccionarPorEdad(Integer edad);   


}
