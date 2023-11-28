package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.demoCoffeeApp.model.ProductoModel;
import com.coffee.demoCoffeeApp.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;
    
    public ProductoModel create(ProductoModel newProducto){
        return this.productoRepository.save(newProducto);
    }

    public List<ProductoModel> findAll(){
        return this.productoRepository.findAll();
    }

    public String findById(Long id){
        JSONObject resultado = null;
        Optional<ProductoModel> productoBD = this.productoRepository.findById(id);
        if(productoBD.isPresent()){
            ProductoModel c = productoBD.get();
            String descripcionClient = "{ \n" + 
                                    "\"id\": " + c.getId() + "," + 
                                    "\"descripcion\": " + "\"" +  c.getDescripcion()+ "\"" + "," + 
                                    "\"cantidad\": " + "\"" +  c.getCantidad()+ "\"" + "," + 
                                    "\"precio\": " + "\"" + c.getPrecio() + "\"" +
                                    "}";
            try{
                resultado = new JSONObject(descripcionClient);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return resultado.toString();
    }

    public ProductoModel updateCantidad(ProductoModel cliente, Long id){
        ProductoModel clienteResultado = null;
        Optional<ProductoModel> productoBD = this.productoRepository.findById(id);
        if(productoBD.isPresent()){
            clienteResultado = productoBD.get();
            clienteResultado.setCantidad(cliente.getCantidad());
            clienteResultado = this.productoRepository.save(clienteResultado);
        }
        return clienteResultado;
    }
    
    public void delete(Long id){
        this.productoRepository.deleteById(id);
    }
}
