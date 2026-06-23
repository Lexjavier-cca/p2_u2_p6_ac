package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.infraestrucure.repository.CuentaBancariaImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {
    @Inject
    private CuentaBancariaImpl cbi;
    public void guardar(CuentaBancaria cuenta){
        this.cbi.insertar(cuenta);
        
    }
}
