package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coffee.demoCoffeeApp.model.FacturacionModel;
import com.coffee.demoCoffeeApp.repository.FacturacionRepository;

@Service
public class FacturacionService {
    
    @Autowired
    FacturacionRepository facturacionRepository;

    public FacturacionModel create(FacturacionModel newFacturacion){
        return this.facturacionRepository.save(newFacturacion);
    }

    public List<FacturacionModel> findAll(){
        return this.facturacionRepository.findAll();
    }

    public String findById(Long id){
        JSONObject resultado = null;
        Optional<FacturacionModel> facturacionBD = this.facturacionRepository.findById(id);
        if(facturacionBD.isPresent()){
            FacturacionModel f = facturacionBD.get();
            String descripcionClient = "{ \n" + 
                                    "\"id\": " + f.getId() + "," + 
                                    "\"idcliente\": " + "\"" +  f.getCliente()+ "\"" + "," +
                                    "\"fecha\": " + "\"" +  f.getFechaCreacion()+ "\"" + "," +
                                    "\"correo\": " + "\"" + f.getValorTotal() + "\"" +
                                    "}";
            try{
                resultado = new JSONObject(descripcionClient);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return resultado.toString();
    }

    // public FacturacionModel update(FacturacionModel facturacion, Long id){
    //     FacturacionModel facturacionResultado = null;
    //     Optional<FacturacionModel> facturacionBD = this.facturacionRepository.findById(id);
    //     if(facturacionBD.isPresent()){
    //         facturacionResultado = facturacionBD.get();
    //         facturacionResultado.setCliente(facturacion.getCliente());
    //         facturacionResultado.setFechaCreacion(facturacion.getFechaCreacion());
    //         facturacionResultado.setValorTotal(facturacion.getValorTotal());
    //         facturacionResultado = this.facturacionRepository.save(facturacionResultado);
    //     }
    //     return facturacionResultado;
    // }
    
    public void delete(Long id){
        this.facturacionRepository.deleteById(id);
    }
}
