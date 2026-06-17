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
            System.out.println("Creando un profesor");
            Profesor profesor = new Profesor();
            profesor.setNombre("Ezequiel");
            profesor.setApellido("Lavezi");
            profesor.setCedula("1722603790");
            profesor.setGenero("Masculino");
            profesor.setCorreo("ezequiel@gmail.com");
            profesor.setTelefono("0998752130");
            profesor.setAsignatura("Programacion Grafica");
            profesor.setFechaNacimiento(LocalDate.of(1983, 5, 17));
            System.out.println(profesor);
            

            System.out.println("----------Insertando un contrato y seteando un profesor----------");
            Contrato contrato = new Contrato();
            contrato.setFechaInicio(LocalDate.of(2026, 3, 4));
            contrato.setSalario(1800.00);
            contrato.setProfesor(profesor);
            System.out.println(contrato);
            this.contratoService.guardar(contrato);
            
            


            return 0;   

            
        }
    }

}