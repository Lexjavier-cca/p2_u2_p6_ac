package ec.edu.uce.domain.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @SequenceGenerator(name = "seq_medico_generador", sequenceName = "seq_medico", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico_generador")
    @Column(name = "medi_id")
    private Integer id;
    @Column(name = "medi_nombre")
    private String nombre;
    @Column(name = "medi_especialidad")
    private String especialidad;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "medico_paciente",joinColumns = @JoinColumn(name = "mepa_id_medico"),inverseJoinColumns = @JoinColumn(name = "mepa_id_paciente"))
    private List<Paciente> pacientes;
    public Medico(){
        
    }
    public Medico(Integer id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
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
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    @Override
    public String toString() {
        return "Medico [id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad 
                + "]";
    }
    

}
