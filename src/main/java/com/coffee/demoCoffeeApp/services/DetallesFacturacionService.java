package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.demoCoffeeApp.model.DetallesFacturacionModel;
import com.coffee.demoCoffeeApp.repository.DetallesFacturacionRepository;

@Service
public class DetallesFacturacionService {
    @Autowired
    DetallesFacturacionRepository detallesFacturacionRepository;

    
    public DetallesFacturacionModel create(DetallesFacturacionModel newfacturacion){
        return this.detallesFacturacionRepository.save(newfacturacion);
    }

    public List<DetallesFacturacionModel> findAll(){
        return this.detallesFacturacionRepository.findAll();
    }

    public String findById(Long id){
        JSONObject resultado = null;
        Optional<DetallesFacturacionModel> detallesBD = this.detallesFacturacionRepository.findById(id);
        if(detallesBD.isPresent()){
            DetallesFacturacionModel d = detallesBD.get();
            String cuerpoDetallesFactulacion = "{ \n" + 
                                    "\"id\": " + d.getId() + "," + 
                                    "\"nombre\": " + "\"" +  d.getFacturacion()+ "\"" + "," + 
                                    "\"nombre\": " + "\"" +  d.getProducto()+ "\"" + "," +
                                    "\"correo\": " + "\"" + d.getCantidadProductos() + "\"" +
                                    "}";
            try{
                resultado = new JSONObject(cuerpoDetallesFactulacion);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return resultado.toString();
    }
    
    // dejo el metodo de hacer un update, si embargo, lo comento ya que esta info no deberia ser modificable, una vez hecha una factura no se modifica
    // public DetallesFacturacionModel update(DetallesFacturacionModel facturacion, Long id){
    //     DetallesFacturacionModel detallesResultado = null;
    //     Optional<DetallesFacturacionModel> detallesBD = this.detallesFacturacionRepository.findById(id);
    //     if(detallesBD.isPresent()){
    //         detallesResultado = detallesBD.get();
    //         detallesResultado.setFacturacion(facturacion.getFacturacion());
    //         detallesResultado.setProducto(facturacion.getProducto());
    //         detallesResultado.setCantidadProductos(facturacion.getCantidadProductos());
    //         detallesResultado = this.detallesFacturacionRepository.save(detallesResultado);
    //     }
    //     return detallesResultado;
    // }
    public void delete(Long id){
        this.detallesFacturacionRepository.deleteById(id);
    }
    
}
