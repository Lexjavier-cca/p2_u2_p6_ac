package ec.edu.uce;

import java.time.LocalDate;

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
            System.out.println("Creando un profesor");
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Alex");
            profesor1.setApellido("Caiza");
            profesor1.setAsignatura("Programacion Avanzada 2");
            profesor1.setGenero("Masculino");
            profesor1.setFechaNacimiento(LocalDate.of(2004, 6, 4));
            System.out.println("CRUD del profesor");
            this.profesorService.guardar(profesor1);
            System.out.println(this.profesorService.buscarPorId(profesor1.getId()));
            profesor1.setAsignatura("Redes y Protocolos de comunicación");
            this.profesorService.actualizar(profesor1);
            System.out.println(this.profesorService.buscarPorId(profesor1.getId()));
            this.profesorService.eliminar(profesor1.getId());

            return 0;   

            
        }
    }

}