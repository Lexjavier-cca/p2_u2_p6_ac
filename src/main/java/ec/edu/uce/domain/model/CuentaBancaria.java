package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentaBancaria")
public class CuentaBancaria {
    @Id
    @SequenceGenerator(name = "seq_cuenta_generador", sequenceName = "seq_cuenta", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_generador")
    @Column(name = "cuen_id")
    private Integer id;
    @Column(name = "cuen_numeroCuenta")
    private String numeroCuenta;
    @Column(name = "cuen_nombreTitular")
    private String nombreTitular;
    @Column(name = "cuen_saldo")
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuentaOrigen")
    private List<TransferenciaBancaria> transferenciasEnviadas;

    @OneToMany(mappedBy = "cuentaDestino")
    private List<TransferenciaBancaria> transferenciasRecibidas;
    public CuentaBancaria(){

    }
    public CuentaBancaria(Integer id, String numeroCuenta, String nombreTitular, BigDecimal saldo) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public String getNombreTitular() {
        return nombreTitular;
    }
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    public BigDecimal getSaldo() {
        return saldo;
    }
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return "CuentaBancaria [id=" + id + ", numeroCuenta=" + numeroCuenta + ", nombreTitular=" + nombreTitular
                + ", saldo=" + saldo + "]";
    }
    
    


}
