package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @SequenceGenerator(name = "seq_paciente_generador", sequenceName = "seq_paciente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente_generador")
    @Column(name = "paci_id")
    private Integer id;
    @Column(name = "paci_nombre")
    private String nombre;
    @Column(name = "paci_padecimiento")
    private String padecimiento;
    @ManyToMany(mappedBy= "pacientes", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Medico> medicos;
    public Paciente(){

    }
    public Paciente(Integer id, String nombre, String padecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.padecimiento = padecimiento;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPadecimiento() {
        return padecimiento;
    }
    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }
    public List<Medico> getMedicos() {
        return medicos;
    }
    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombre=" + nombre + ", padecimiento=" + padecimiento 
                + "]";
    }
    

    
    
    
    
}
