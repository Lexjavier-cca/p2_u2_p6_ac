package ec.edu.uce.application.service;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.TransferenciaBancaria;
import ec.edu.uce.infraestrucure.repository.TransferenciaBancariaImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaBancariaService {
    @Inject
    private TransferenciaBancariaImpl tbi;
    public void guardar(TransferenciaBancaria transferenciaBancaria){
        this.tbi.insertar(transferenciaBancaria);
        
    }
    public TransferenciaBancaria realizarTransferencia(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, BigDecimal monto){
        return this.tbi.transferir(cuentaOrigen, cuentaDestino, monto);
    }
}
