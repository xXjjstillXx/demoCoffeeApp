package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.demoCoffeeApp.exceptions.ProductoException;
import com.coffee.demoCoffeeApp.model.ProductoModel;
import com.coffee.demoCoffeeApp.repository.ProductoRepository;
import com.coffee.demoCoffeeApp.validators.ProductoValidator;
// import org.json.JSONException;
// import org.json.JSONObject;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;
    ProductoValidator validacionProducto = new ProductoValidator();
    
    public String create(ProductoModel newProducto) throws ProductoException{
        validacionProducto.validarProducto(newProducto);
        productoRepository.save(newProducto);
        return "Producto creado exitosamente";
    }

    public List<ProductoModel> findAll(){
        return this.productoRepository.findAll();
    }

    public ProductoModel findById(Long id){
        ProductoModel producto = null;
        Optional<ProductoModel> productoBD = this.productoRepository.findById(id);
        if(productoBD.isPresent()){
            producto = productoBD.get();
        }else{
            producto = new ProductoModel();
        }
        return producto;
    }

    public ProductoModel updateCantidad(ProductoModel producto, Long id){
        ProductoModel productoResultado = null;
        Optional<ProductoModel> productoBD = this.productoRepository.findById(id);
        if(productoBD.isPresent()){
            productoResultado = productoBD.get();
            productoResultado.setCantidad(producto.getCantidad());
            productoResultado = this.productoRepository.save(productoResultado);
        }else{
            productoResultado = new ProductoModel();
        }
        return productoResultado;
    }
    
    public String delete (Long id){
        String resultado = "El producto no se encuentra en base de datos";
        if(productoRepository.existsById(id)){
            this.productoRepository.deleteById(id);
            resultado = "Cliente eliminado exitosamente";
        }
        return resultado;

    }
    
    // public String findById(Long id){
    //     JSONObject resultado = null;
    //     Optional<ProductoModel> productoBD = this.productoRepository.findById(id);
    //     if(productoBD.isPresent()){
    //         ProductoModel c = productoBD.get();
    //         String descripcionClient = "{ \n" + 
    //                                 "\"id\": " + c.getId() + "," + 
    //                                 "\"descripcion\": " + "\"" +  c.getDescripcion()+ "\"" + "," + 
    //                                 "\"cantidad\": " + "\"" +  c.getCantidad()+ "\"" + "," + 
    //                                 "\"precio\": " + "\"" + c.getPrecio() + "\"" +
    //                                 "}";
    //         try{
    //             resultado = new JSONObject(descripcionClient);
    //         }catch(JSONException e){
    //             e.printStackTrace();
    //         }
    //     }
    //     return resultado.toString();
    // }
}
