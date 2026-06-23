package ec.edu.uce.domain.repositoy;

import java.math.BigDecimal;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.TransferenciaBancaria;

public interface TransferenciaBancariaRepository{
    public void insertar(TransferenciaBancaria transferencia);
    public TransferenciaBancaria transferir(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, BigDecimal monto);
}
