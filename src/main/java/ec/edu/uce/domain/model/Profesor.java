package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.buscarPorCedulaPichincha", query = "SELECT p FROM Profesor p WHERE p.cedula LIKE '17%'"),
    @NamedQuery(name = "Profesor.contarProfesoresCalculo", query = "SELECT COUNT(p) FROM Profesor p WHERE p.asignatura LIKE 'Calculo%'"),
    @NamedQuery(name = "Profesor.buscarPorCorreoInstitucional", query = "SELECT p FROM Profesor p WHERE p.correo LIKE '%@uce.edu.ec%'"),
    @NamedQuery(name = "Profesor.buscarPorGeneroFemenino", query = "SELECT p FROM Profesor p WHERE p.genero = 'Femenino'")
})
public class Profesor {
    @Id
    @SequenceGenerator(name = "seq_profesor_generador", sequenceName = "seq_profesor", allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generador") 
    @Column(name = "prof_id")
    private Integer id;
    @Column(name = "prof_cedula")
    private String cedula;
    @Column(name = "prof_nombre")
    private String nombre;  
    @Column(name = "prof_apellido")
    private String apellido;
    @Column(name = "prof_asignatura")
    private String asignatura;
    @Column(name = "prof_genero")
    private String genero;
    @Column(name = "prof_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "prof_correo")
    private String correo;
    @Column(name = "prof_telefono")
    private String telefono;
    public Profesor() {
    } 
    public Profesor(Integer id, String cedula,String nombre, String apellido, String asignatura, String genero,
            LocalDate fechaNacimiento, String correo, String telefono) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.telefono = telefono;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Profesor [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", asignatura=" + asignatura
                + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", correo=" + correo + ", telefono=" + telefono + "]";
    }


}
