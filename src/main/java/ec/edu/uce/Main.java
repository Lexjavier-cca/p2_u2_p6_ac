package ec.edu.uce;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.CuentaBancariaService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.application.service.TransferenciaBancariaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.model.Pedido;
import ec.edu.uce.domain.model.TransferenciaBancaria;
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
        private CuentaBancariaService cuenta;
        @Inject
        private TransferenciaBancariaService transferencia;

      
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
          
            CuentaBancaria c1 = new CuentaBancaria();
            c1.setNombreTitular("Alex Caiza");
            c1.setNumeroCuenta("C-001");
            c1.setSaldo(BigDecimal.valueOf(1000.50));
            this.cuenta.guardar(c1);

            CuentaBancaria c2 = new CuentaBancaria();
            c2.setNombreTitular("Alan Brito");
            c2.setNumeroCuenta("C-002");
            c2.setSaldo(BigDecimal.valueOf(200.00));
            this.cuenta.guardar(c2);

            TransferenciaBancaria t1 = this.transferencia.realizarTransferencia(c1, c2, BigDecimal.valueOf(100.00));
            t1.setCuentaOrigen(c1);
            t1.setCuentaDestino(c2);

            this.transferencia.guardar(t1);


           
            return 0;
   
        }
    }

}