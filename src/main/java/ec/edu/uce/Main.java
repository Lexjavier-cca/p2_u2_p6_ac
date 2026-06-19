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
            

            return 0;   
        
        }
    }

}