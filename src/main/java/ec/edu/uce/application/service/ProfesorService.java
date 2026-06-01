package ec.edu.uce.application.service;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repositoy.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {
    @Inject
    private ProfesorRepository profesorRepository;
    public void guardar(Profesor profesor){
        this.profesorRepository.crear(profesor);
    }
    public Profesor buscarPorId(Integer id){
        return this.profesorRepository.seleccionarPorId(id);
    }
    public void actualizar(Profesor profesor){
        this.profesorRepository.actualizar(profesor);
    }
    public void eliminar(Integer id){
        this.profesorRepository.eliminar(id);
    }
    public List<Profesor> seleccionarPorAsignatura(String asignatura){
        return this.profesorRepository.seleccionarPorAsignatura(asignatura);
    }
    public List<Profesor> seleccionarPorCorreo(String dominio){
        return this.profesorRepository.seleccionarPorCorreo(dominio);
    }
    public List<Profesor> seleccionarPorCedulaPichinchaOGuayas(){
        return this.profesorRepository.seleccionarPorCedulaPichinchaOGuayas();
    }
    public List<Profesor> buscarPorCedulaPichincha(){
        return this.profesorRepository.buscarPorCedulaPichincha();
    }
    public Long contarProfesoresCalculo(){
        return this.profesorRepository.contarProfesoresCalculo();
    }
    public List<Profesor> buscarPorCorreoInstitucional(){
        return this.profesorRepository.buscarPorCorreoInstitucional();
    }
    public List<Profesor> buscarPorGeneroFemenino(){
        return this.profesorRepository.buscarPorGeneroFemenino();
    }  
    public List<Profesor> seleccionarTodosNative(){
        return this.profesorRepository.seleccionarTodosNative();
    }
    public List<Profesor> seleccionarPorRangodeFechadeNacimiento(LocalDate inicio, LocalDate fin){
        return this.profesorRepository.seleccionarPorRangodeFechadeNacimiento(inicio, fin);
    }
    public List<Profesor> seleccionarPorCedulaGuayasyTelefono(Integer fin){
        return this.profesorRepository.seleccionarPorCedulaGuayasyTelefono(fin);
    }
    public Long contarProfesoresConIDMayorA(Integer id){
        return this.profesorRepository.contarProfesoresConIDMayorA(id);
    } 

}
