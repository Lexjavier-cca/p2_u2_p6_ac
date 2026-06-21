package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Medico;
import ec.edu.uce.infraestrucure.repository.MedicoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MedicoService {
    @Inject
    private MedicoRepositoryImpl mri;
    public void guardar(Medico medico){
        this.mri.insertar(medico);
    }
    public Medico mostrarPorId(Integer id){
        return this.mri.seleccionarPorId(id);
    }

}
