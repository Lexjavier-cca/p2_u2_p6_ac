package ec.edu.uce;

import java.util.List;

import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Profesor;
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
        private ProfesorService profesorService;
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            System.out.println("Consultas con profesores");
            System.out.println("Mostrar todos los profesores Criteria");

            List<Profesor> profesores1 = this.profesorService.buscarTodosCriteria();
            for(Profesor p1 : profesores1){
                System.out.println(p1);
            }
            System.out.println("Profesores con el apellido Brito");
            List<Profesor> profesores2 = this.profesorService.encontrarPorApellido("Brito");
            for(Profesor p2 : profesores2){
                System.out.println(p2);
            }
            System.out.println("Profesores con la edad de 35 años");
            List<Profesor> profesores3 = this.profesorService.mostrarPorEdad(35);
            for(Profesor p3 : profesores3){
                System.out.println(p3);
            }


            return 0;   

            
        }
    }

}