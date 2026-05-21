package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repositoy.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteService {
    @Inject
    private EstudianteRepository estudianteRepository;
    public void guardar(Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);
    }
    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionarPorId(id);
    }
    public void actualizar(Estudiante estudiante){
        this.estudianteRepository.actualizar(estudiante);
    }
    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);
    }
}
