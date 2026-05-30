package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import java.util.List;
@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class,args);
           
       
    }
    public static class App implements QuarkusApplication{
        @Inject
        private EstudianteService estudianteService;
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            System.out.println("Mostrando todos los estudiantes");

            List<Estudiante> lista = this.estudianteService.buscarPorGenero("Masculino");
            for(Estudiante e: lista){
                System.out.println(e);
            }
            System.out.println("Mostrando todos los estudiantes Query");
            List<Estudiante> lista2 = this.estudianteService.buscarPorGeneroTyped("Masculino");
            for(Estudiante e: lista2){
                System.out.println(e);
            }
            System.out.println("Mostrando todos los estudiantes por rango de fecha,2000");
            List<Estudiante> lista3 = this.estudianteService.buscarPorRangoFecha(LocalDate.of(2004, 1, 1), LocalDate.of(2004, 12, 31));
            for(Estudiante e: lista3){
                System.out.println(e);
            }
            System.out.println("Contar estudiantes");
            Long cantidad = this.estudianteService.contar();
            System.out.println("Cantidad de estudiantes: "+cantidad);
            System.out.println("Mostrando todos los estudiantes Native Query");
            List<Estudiante> lista4 = this.estudianteService.buscarTodosNative();
            for(Estudiante e: lista4){
                System.out.println(e);
            }
             


    
            return 0;

            
        }
    }

}