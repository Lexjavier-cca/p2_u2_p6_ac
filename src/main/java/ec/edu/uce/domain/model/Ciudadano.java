package ec.edu.uce.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
    @Id
    @SequenceGenerator(name = "seq_ciudadano_generador", sequenceName = "seq_ciudadano", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciudadano_generador")   
    @Column(name = "ciu_id")
    private Integer id;
    @Column(name = "ciu_nomber")
    private String nombre;
    @Column(name = "ciu_fecha_nacimiento")
    private LocalDateTime fecha_nacimiento;
    public Ciudadano() {
    }

    public Ciudadano(int i, String string, LocalDateTime of) {
        //TODO Auto-generated constructor stub
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
    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    @Override
    public String toString() {
        return "Ciudadano [id=" + id + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + "]";
    }
    

}
