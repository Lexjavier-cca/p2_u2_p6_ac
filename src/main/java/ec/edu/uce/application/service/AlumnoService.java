package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.infraestrucure.repository.AlumnoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoService {
    @Inject
    private AlumnoRepositoryImpl ari;
    public void guardar(Alumno alumno){
        this.ari.insertar(alumno);
    }
    public Alumno mostrarPorId(Integer id){
        return this.ari.consultarPorId(id);
    }
}
