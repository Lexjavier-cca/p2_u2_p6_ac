package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.ContratoService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Contrato;
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
        @Inject
        private ContratoService contratoService;
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            System.out.println("Creando un profesor y un contrato");
            Profesor profesor = new Profesor();
            System.out.println("Profesor con id 17");
            profesor.setNombre("Ariel");
            profesor.setApellido("Morocho");
            profesor.setCedula("1722603291");
            profesor.setGenero("Masculino");
            profesor.setCorreo("alan@gmail.com");
            profesor.setTelefono("0998752140");
            profesor.setAsignatura("Ecuaciones Diferenciales");
            profesor.setFechaNacimiento(LocalDate.of(1985, 4, 21));
            //this.profesorService.guardar(profesor);
            Contrato contrato = new Contrato();
            contrato.setFechaInicio(LocalDate.of(2026, 6, 11));
            contrato.setSalario(1200.0);
            contrato.setProfesor(profesor);
            this.contratoService.guardar(contrato);
            
            


            return 0;   

            
        }
    }

}