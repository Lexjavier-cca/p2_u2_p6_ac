package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Estudiante;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class,args);
           
       
    }
    public static class App implements QuarkusApplication{
      
        @Inject
        private CiudadanoService ciud;
      
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            Ciudadano ciudadano1 = new Ciudadano(10 , "Alex C",LocalDateTime.of(2005, 7, 30, 1, 3));
            this.ciud.guardar(ciudadano1);
            

            
            
            return 0;

            
        }
    }

}