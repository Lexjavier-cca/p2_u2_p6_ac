package ec.edu.uce.application.service;

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

}
