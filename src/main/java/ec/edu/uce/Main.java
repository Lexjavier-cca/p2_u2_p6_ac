package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;
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
        private EstudianteService estudianteService;
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Alex");
            estudiante.setApellido("Caiza");
            estudiante.setGenero("Masculino");
            estudiante.setFechaNacimiento(LocalDate.of(2004, 6, 4));
            this.estudianteService.guardar(estudiante);
            System.out.println(this.estudianteService.buscarPorId(estudiante.getId()));
            estudiante.setApellido("Calispa");
            this.estudianteService.actualizar(estudiante);
            System.out.println(this.estudianteService.buscarPorId(estudiante.getId()));
            this.estudianteService.eliminar(estudiante.getId());
            System.out.println();
            
            return 0;

            
        }
    }

}