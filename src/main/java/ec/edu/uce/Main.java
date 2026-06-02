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

            System.out.println("Mostrando todos los estudiantes Criteria");
            List<Estudiante> lista5 = this.estudianteService.buscarTodosCriteria();
            for(Estudiante e: lista5){
                System.out.println(e.getNombre() + " " + e.getApellido());
            }
            System.out.println("Mostrando por nombre Criteria");
            List<Estudiante> lista6 = this.estudianteService.buscarPorNombreCriteria("Alma");
            for(Estudiante e: lista6){
                System.out.println(e);
            }
            System.out.println("Mostrando por nombre y apellido Criteria");
            List<Estudiante> lista7 = this.estudianteService.buscarDinamicoCriteria("Alex", "Caiza");
            for(Estudiante e: lista7){
                System.out.println(e.getNombre() + " " + e.getApellido());
            }
            System.out.println("Mostrando por nombre y apellido Criteria con null");
            List<Estudiante> lista8 = this.estudianteService.buscarDinamicoCriteria(null, null);
            for(Estudiante e: lista8){
                System.out.println(e);
            }
            System.out.println("Mostrando por nombre Criteria con apellido null");
            List<Estudiante> lista9 = this.estudianteService.buscarDinamicoCriteria("Alex", null);
            for(Estudiante e: lista9){
                System.out.println(e.getNombre());
            }
            System.out.println("Mostrando por apellido Criteria con nombre null");
            List<Estudiante> lista10 = this.estudianteService.buscarDinamicoCriteria(null, "Caiza");
            for(Estudiante e: lista10){
                System.out.println(e.getApellido());
            }

            return 0;

            
        }
    }

}