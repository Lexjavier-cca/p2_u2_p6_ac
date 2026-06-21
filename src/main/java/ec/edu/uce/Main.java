package ec.edu.uce;

import java.util.List;

import ec.edu.uce.application.service.MedicoService;
import ec.edu.uce.application.service.PacienteService;
import ec.edu.uce.domain.model.Medico;
import ec.edu.uce.domain.model.Paciente;
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
        private PacienteService pacienteService;
        @Inject
        private MedicoService medicoService;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("Conexion a una base de datos");

        System.out.println("Creando pacientes");
        Paciente p1 = new Paciente();
        p1.setNombre("Adalberto");
        p1.setPadecimiento("Gripe");

        Paciente p2 = new Paciente();
        p2.setNombre("Lucía");
        p2.setPadecimiento("Infeccion Estomacal");

        Paciente p3 = new Paciente();
        p3.setNombre("Ivan");
        p3.setPadecimiento("Desgarro Muscular");

        System.out.println("Creando medicos");

        Medico m1 = new Medico();
        m1.setNombre("Alex");
        m1.setEspecialidad("Enfermedades Respiratorias");

        Medico m2 = new Medico();
        m2.setNombre("Andres");
        m2.setEspecialidad("Enfermedades bacterianas y virales");

        Medico m3 = new Medico();
        m3.setNombre("Micaela");
        m3.setEspecialidad("Dolencias musculares");

        p1.setMedicos(List.of(m1, m2, m3));

        m3.setPacientes(List.of(p1, p2, p3));

        this.pacienteService.guardar(p1);

        System.out.println("Medicos del Paciente con el Id: " + p1.getId() + " y nombre: " + p1.getNombre());
        for (Medico medico : p1.getMedicos()) {
            System.out.println(medico);
        }

        System.out.println("Pacientes del medico con el Id: " + m3.getId() + " y nombre: " + m3.getNombre());
        for (Paciente paciente : m3.getPacientes()) {
            System.out.println(paciente);
        }

        return 0;
        }
    }

}