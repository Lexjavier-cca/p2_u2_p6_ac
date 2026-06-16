package ec.edu.uce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
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
        
        @Inject
        private EmpleadoService empl;
      
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            System.out.println("Insertando un ciudadado");
            Ciudadano ciudadano1 = new Ciudadano();
            ciudadano1.setNombre("Pere Milla");
            ciudadano1.setFecha_nacimiento(LocalDateTime.of(1991, 6, 7,4,0));

            
            

            //this.ciud.guardar(ciudadano1);
           // System.out.println(ciudadano1.getId());
            System.out.println("Insertando un empleado");
            Empleado empleado1 = new Empleado();
            empleado1.setSalario(null);
            empleado1.setFechaIngreso(LocalDateTime.of(2024,11,13,8,0));
            empleado1.setCiudadano(ciudadano1);
            this.empl.guardar(empleado1);
            
            

            
            
            return 0;

            
        }
    }

}