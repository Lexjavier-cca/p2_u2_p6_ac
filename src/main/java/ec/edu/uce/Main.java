package ec.edu.uce;




import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.EquipoService;
import ec.edu.uce.domain.model.Equipo;
import ec.edu.uce.domain.model.Jugador;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class,args);
           
       
    }
    public static class App implements QuarkusApplication{
        @Inject
        private EquipoService equipoService;

        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            System.out.println("Creando un equipo");
            Equipo equipo = new Equipo();
            equipo.setNombre("Real Madrid");
            equipo.setCiudad("Madrid");
            equipo.setTrofeos(15);
            Jugador jugador1 = new Jugador();
            jugador1.setNombre("Andry Lunin");
            jugador1.setDorsal(13);
            jugador1.setPosicion("Portero");
            jugador1.setEquipo(equipo);
            Jugador jugador2 = new Jugador();
            jugador2.setNombre("Kylian Mbappe");
            jugador2.setDorsal(9);
            jugador2.setPosicion("Delantero");
            jugador2.setEquipo(equipo);
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador1);
            jugadores.add(jugador2);
            equipo.setJugadores(jugadores);
            this.equipoService.guardar(equipo);
            return 0;   
        
        }
    }

}