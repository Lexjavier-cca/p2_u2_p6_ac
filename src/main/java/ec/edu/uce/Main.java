package ec.edu.uce;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
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
        private ClienteService cs;

      
        @Override
        public int run(String... args) throws Exception {
            System.out.println("Conexion a una base de datos");
            Cliente cliente = new Cliente();
            cliente.setNombre("Alex");
            cliente.setCedula("1722619580");

            Pedido pedido = new Pedido();
            pedido.setTotal(Double.valueOf(18));
            pedido.setCliente(cliente);
            pedido.setFecha(LocalDate.of(2026,6,17));

            Pedido pedido1 = new Pedido();
            pedido1.setTotal(Double.valueOf(23));
            pedido1.setCliente(cliente);
            pedido1.setFecha(LocalDate.of(2026,6,16));
            
            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(pedido1);
            pedidos.add(pedido);

            cliente.setPedidos(pedidos);
            this.cs.guardar(cliente);
            
            return 0;
   
        }
    }

}