package ec.edu.uce.application.service;

import java.time.LocalDateTime;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.infraestrucure.repository.EmpleadoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped

public class EmpleadoService {
    @Inject
    private EmpleadoRepositoryImpl eri;
    @Inject 
    private CiudadanoService cs;
    @Transactional
    public void guardar(Empleado empleado){
        System.out.println("Conexion a una base de datos");
        /**System.out.println("Insertando un ciudadado");
        Ciudadano ciudadano1 = new Ciudadano();
        ciudadano1.setNombre("Matias Perello");
        ciudadano1.setFecha_nacimiento(LocalDateTime.of(1991, 6, 7,4,0));
        this.cs.guardar(ciudadano1);
        ciudadano1.setNombre("Hernan Pellerano");
        empleado.setCiudadano(ciudadano1);**/
        this.eri.insertar(empleado);
        
    }

}
