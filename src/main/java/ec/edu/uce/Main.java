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

            List<Estudiante> lista = this.estudianteService.buscarTodos();

            for (Estudiante e : lista) {
               System.out.println(e);
            }
            System.out.println("Mostrando estudiantes por nombre Alex");
            List<Estudiante> lista2 = this.estudianteService.buscarPorNombre("Alex");
            for (Estudiante e : lista2) {
               System.out.println(e);
            }  
            System.out.println("Mostrando estudiantes por cedula 1104681237");
            System.out.println(this.estudianteService.buscarPorCedula("1104681237"));
            return 0;

            
        }
    }

}