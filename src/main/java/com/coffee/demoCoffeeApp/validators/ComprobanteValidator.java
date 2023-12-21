package com.coffee.demoCoffeeApp.validators;

// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;

// import com.coffee.demoCoffeeApp.exceptions.ComprobanteException;
// import com.coffee.demoCoffeeApp.model.ClienteModel;
// import com.coffee.demoCoffeeApp.model.ComprobanteModel;
// import com.coffee.demoCoffeeApp.model.LineaModel;
// import com.coffee.demoCoffeeApp.repository.ClienteRepository;
// import com.coffee.demoCoffeeApp.repository.ProductoRepository;

public class ComprobanteValidator {

    // Traté de hacerlo acá pero me salió un error que no me dio tiempo a corregir por ahora
    // @Autowired
    // private ProductoRepository productoRepository;

    // @Autowired
    // private ClienteRepository clienteRepository;

    // public void validarComprobante (ComprobanteModel comprobante) throws ComprobanteException{
    //     if(!existeCliente(comprobante.getCliente())){
    //         throw new ComprobanteException("El cliente no existe en base de datos");
    //     }
    //     if(!existenProductos(comprobante.getLineas())){
    //         throw new ComprobanteException("Producto no existe en base de datos");
    //     }
    //     if(!existeStock(comprobante.getLineas())){
    //         throw new ComprobanteException("No hay Stock disponible");
    //     }
        
        

        
    // }
    // private Boolean existeStock(Set<LineaModel> lineas) {
    //     for (LineaModel linea : lineas) {
    //         var productoid = linea.getProducto().getId();
    //         var opProducto = this.productoRepository.findById(productoid);
    //         if (opProducto.isEmpty()) {
    //             return false;
    //         }
    //         if (linea.getCantidad() < opProducto.get().getCantidad()) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    // private Boolean existenProductos(Set<LineaModel> lineas) {
    //     for (LineaModel linea : lineas) {
    //         var productoId = linea.getProducto().getId();
    //         var opProducto = this.productoRepository.findById(productoId);
    //         if (opProducto.isEmpty()) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    // private Boolean existeCliente(ClienteModel cliente) {
    //     var opCliente = this.clienteRepository.findById(cliente.getId());
    //     return !opCliente.isEmpty();
    // }
}
