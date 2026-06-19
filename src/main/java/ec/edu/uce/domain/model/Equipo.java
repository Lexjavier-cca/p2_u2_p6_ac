package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @SequenceGenerator(name = "seq_equipo_generador", sequenceName = "seq_equipo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipo_generador")
    @Column(name = "equi_id")
    private Integer id;
    @Column(name = "equi_nombre")
    private String nombre;
    @Column(name = "equi_ciudad")
    private String ciudad;
    @Column(name = "equi_trofeos")
    private Integer trofeos;
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;
    public Equipo() {
    }
    public Equipo(Integer id, String nombre, String ciudad, Integer trofeos) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.trofeos = trofeos;
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
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getTrofeos() {
        return trofeos;
    }
    public void setTrofeos(Integer trofeos) {
        this.trofeos = trofeos;
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", trofeos=" + trofeos +
                '}';
    }





}
