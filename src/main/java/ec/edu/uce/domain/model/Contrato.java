package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @SequenceGenerator(name = "seq_contrato_generador", sequenceName = "seq_contrato", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contrato_generador")
    @Column(name = "ctr_id")
    private Integer id;
    @Column(name = "ctr_fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "ctr_salario")
    private Double salario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    public Contrato() {
    }
    public Contrato(Integer id, LocalDate fechaInicio, Double salario, Profesor profesor) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.salario = salario;
        this.profesor = profesor;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    @Override
    public String toString() {
        return "Contrato [id=" + id + ", fechaInicio=" + fechaInicio + ", salario=" + salario + ", profesor=" + profesor
                + "]";
    }
    
    



}
