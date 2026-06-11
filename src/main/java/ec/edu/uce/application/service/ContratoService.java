package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Contrato;
import ec.edu.uce.infraestrucure.repository.ContratoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ContratoService {
    @Inject
    private ContratoRepositoryImpl cr;
    public void guardar(Contrato contrato){
        this.cr.crear(contrato);
        
    }
}
