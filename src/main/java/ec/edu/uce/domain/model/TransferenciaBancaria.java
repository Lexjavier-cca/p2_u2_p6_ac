package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferenciaBancaria")
public class TransferenciaBancaria {
    @Id
    @SequenceGenerator(name = "seq_transferencia_generador", sequenceName = "seq_transferencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia_generador") 
    @Column(name = "trans_id")
    public Integer id;

    @Column(name = "trans_monto")
    public BigDecimal monto;

    @Column(name = "trans_fecha")
    public LocalDateTime fecha;

    @ManyToOne 
    @JoinColumn(name = "trans_cuenta_origen_id")
    public CuentaBancaria cuentaOrigen;

    @ManyToOne 
    @JoinColumn(name = "trans_cuenta_destino_id")
    public CuentaBancaria cuentaDestino;

    public TransferenciaBancaria() {
    }
    public TransferenciaBancaria(Integer id, BigDecimal monto, LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }
    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }
    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    @Override
    public String toString() {
        return "TransferenciaBancaria [id=" + id + ", monto=" + monto + ", fecha=" + fecha + ", cuentaOrigen="
                + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + "]";
    }
    

}
