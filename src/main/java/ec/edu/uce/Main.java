package ec.edu.uce;

import java.time.LocalDate;
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
            System.out.println("Todos los profesores native");
            List<Profesor> profesores = this.profesorService.seleccionarTodosNative();
            for(Profesor p: profesores){
                System.out.println(p);
            }
            System.out.println("Profesores que nacieron entre 1980 y 1990");
            List<Profesor> profesores2 = this.profesorService.seleccionarPorRangodeFechadeNacimiento(LocalDate.of(1980, 1, 1), LocalDate.of(1990, 12, 31));
            for(Profesor p: profesores2){
                System.out.println(p);
            }
            System.out.println("Profesores con cedula que termina en 9 y telefono que termina en 9");
            List<Profesor> profesores3 = this.profesorService.seleccionarPorCedulaGuayasyTelefono(9);
            for(Profesor p: profesores3){
                System.out.println(p);
            }
            Long conteo = this.profesorService.contarProfesoresConIDMayorA(5);
            System.out.println("Cantidad de profesores con ID mayor a 5: " + conteo);
            return 0;   

            
        }
    }

}