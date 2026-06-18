package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.infraestrucure.repository.ClienteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteService {
    @Inject
    private ClienteRepositoryImpl cri;

    public void guardar(Cliente cliente){
        this.cri.crear(cliente);
    }
}
