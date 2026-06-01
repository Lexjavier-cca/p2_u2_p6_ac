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
            System.out.println("Profesores con cédula de Pichincha: " );
            List<Profesor> profesoresPichincha = this.profesorService.buscarPorCedulaPichincha();
            for(Profesor p: profesoresPichincha){
                System.out.println(p);
            }
            System.out.println("Cantidad de profesores que imparten cálculo: " + this.profesorService.contarProfesoresCalculo());
            System.out.println("Profesores con correo institucional: " );
            List<Profesor> profesoresCorreoInstitucional = this.profesorService.buscarPorCorreoInstitucional();
            for(Profesor p: profesoresCorreoInstitucional){
                System.out.println(p);
            }
            System.out.println("Profesores de género femenino: " );
            List<Profesor> profesoresGeneroFemenino = this.profesorService.buscarPorGeneroFemenino();
            for(Profesor p: profesoresGeneroFemenino){
                System.out.println(p);
            }

            return 0;   

            
        }
    }

}