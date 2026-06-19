package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @SequenceGenerator(name = "seq_jugador_generador", sequenceName = "seq_jugador", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jugador_generador")
    @Column(name = "juga_id")
    private Integer id;
    @Column(name = "juga_nombre")
    private String nombre;
    @Column(name = "juga_posicion")
    private String posicion;
    @Column(name = "juga_dorsal")
    private Integer dorsal;
    @ManyToOne
    private Equipo equipo;

    public Jugador() {
    }
    public Jugador(Integer id, String nombre, String posicion, Integer dorsal) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
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
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public Integer getDorsal() {
        return dorsal;
    }
    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }
    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                '}';
    }
}
