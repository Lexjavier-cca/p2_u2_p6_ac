package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Paciente;
import ec.edu.uce.infraestrucure.repository.PacienteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional

public class PacienteService {
    @Inject
    private PacienteRepositoryImpl pri;
    public void guardar(Paciente paciente){
        this.pri.insertar(paciente);

    }
    public Paciente mostrarPorId(Integer id){
        return this.pri.seleccionarPorId(id);
        
    }
}
