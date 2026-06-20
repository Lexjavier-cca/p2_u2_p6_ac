package ec.edu.uce;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.model.Pedido;
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
        private MateriaService materiaService;
        @Inject
        private AlumnoService alumnoService;

      
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            //Alumno con dos materias
            Alumno a1 = new Alumno();
            a1.setNombre("Alex");
            Materia m1 = new Materia();
            m1.setNombre("P.Avanzada");
            m1.setNumeroCreditos(4);
            Materia m2 = new Materia();
            m2.setNombre("P.web");
            m2.setNumeroCreditos(6);

            List<Materia> materias = List.of(m1,m2);
            a1.setMaterias(materias);
            
            //Insert mediante Service de alumno
            this.alumnoService.guardar(a1);
            Materia m3 = new Materia();
            m3.setNombre("P.Distribuida");
            m3.setNumeroCreditos(8);

            Alumno a2 = new Alumno();
            a2.setNombre("Rita");
            a2.setMaterias(List.of(m3));
            Alumno a3 = new Alumno();
            a3.setNombre("Benito");
            a2.setMaterias(List.of(m3));

            m3.setAlumnos(List.of(a2,a3));
            this.materiaService.guardar(m3);
            Materia mater = this.materiaService.mostrarPorId(1);
            System.out.println("Materia con id"+ mater.getId() + mater.getNombre());
            List<Alumno> alumnosMateria = mater.getAlumnos();
            for(Alumno alumnos : alumnosMateria){
                System.out.println(alumnos);
            }
            Alumno alumno = this.alumnoService.mostrarPorId(1);
            System.out.println(alumno.getNombre());
            List<Materia> materiasAlumno = alumno.getMaterias();
            for(Materia materias1: materiasAlumno){
                System.out.println(materias1);
            }
            
            return 0;
   
        }
    }

}