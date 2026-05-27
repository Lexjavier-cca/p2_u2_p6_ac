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
            System.out.println("Profesores que imparten Calculo 1");
            List<Profesor> profesoresCalculo = this.profesorService.seleccionarPorAsignatura("Calculo 1");
            for(Profesor profesor : profesoresCalculo){
                System.out.println(profesor);
            }
            System.out.println("Profesores con correo de dominio @gmail.com");
            List<Profesor> profesoresGmail = this.profesorService.seleccionarPorCorreo( "gmail.com");
            for(Profesor profesor : profesoresGmail){
                System.out.println(profesor);
            }
            System.out.println("Profesores con cedula de Pichincha o Guayas");
            List<Profesor> profesoresPichinchaGuayas = this.profesorService.seleccionarPorCedulaPichinchaOGuayas();
            for(Profesor profesor : profesoresPichinchaGuayas){
                System.out.println(profesor);
            }
            return 0;   

            
        }
    }

}