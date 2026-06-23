package ec.edu.uce.infraestrucure.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.TransferenciaBancaria;
import ec.edu.uce.domain.repositoy.TransferenciaBancariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@ApplicationScoped
@Transactional
public class TransferenciaBancariaImpl implements TransferenciaBancariaRepository {
    @Inject
    private EntityManager em;
    @Override
    public void insertar(TransferenciaBancaria transferencia) {
        // TODO Auto-generated method stub
        this.em.persist(transferencia);
    }

    @Override
    public TransferenciaBancaria transferir(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, BigDecimal monto) {
        // TODO Auto-generated method stub
        TransferenciaBancaria transferencia = new TransferenciaBancaria();
        System.out.println("Iniciando transferencia...............");
        System.out.println("Numero de la cuenta origen: "+ cuentaOrigen.getNumeroCuenta());
        System.out.println("Nombre del titular de la cuenta origen: "+ cuentaOrigen.getNombreTitular());
        System.out.println("Saldo de la cuenta origen: " + cuentaOrigen.getSaldo());
        System.out.println("Nombre del titular de la cuenta destino: "+ cuentaDestino.getNombreTitular());
        System.out.println("Numero de la cuenta de destino: " + cuentaDestino.getNumeroCuenta());
        System.out.println("Saldo de la cuenta destino: " + cuentaDestino.getSaldo());
        if(cuentaOrigen.getSaldo().compareTo(monto) < 0){
            System.out.println("No se puede realizar la transferencia, monto insuficiente");
        }else{
            BigDecimal nuevoSaldoOrigen = cuentaOrigen.getSaldo().subtract(monto);
            cuentaOrigen.setSaldo(nuevoSaldoOrigen);

            BigDecimal nuevoSaldoDestino = cuentaDestino.getSaldo().add(monto);
            cuentaDestino.setSaldo(nuevoSaldoDestino);
            System.out.println("Nuevo saldo de la cuenta origen: " + cuentaOrigen.getSaldo());
            System.out.println("Nuevo saldo de la cuenta destino: " + cuentaDestino.getSaldo());
            
            transferencia.setMonto(monto);
            transferencia.setFecha(LocalDateTime.of(2026, 6, 22, 18, 56));
            return transferencia;
        }
        return transferencia;
    }

}
