package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.demoCoffeeApp.model.ClienteModel;
import com.coffee.demoCoffeeApp.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ClienteModel create(ClienteModel newCliente){
        return this.clienteRepository.save(newCliente);
    }

    public List<ClienteModel> findAll(){
        return this.clienteRepository.findAll();
    }

    public String findById(Long id){
        JSONObject resultado = null;
        Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
        if(clienteBD.isPresent()){
            ClienteModel c = clienteBD.get();
            String descripcionClient = "{ \n" + 
                                    "\"id\": " + c.getId() + "," + 
                                    "\"nombre\": " + "\"" +  c.getNombre()+ "\"" + "," + 
                                    "\"correo\": " + "\"" + c.getCorreo() + "\"" +
                                    "}";
            try{
                resultado = new JSONObject(descripcionClient);
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return resultado.toString();
    }

    public ClienteModel update(ClienteModel cliente, Long id){
        ClienteModel clienteResultado = null;
        Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
        if(clienteBD.isPresent()){
            clienteResultado = clienteBD.get();
            clienteResultado.setNombre(cliente.getNombre());
            clienteResultado.setCorreo(cliente.getCorreo());
            clienteResultado.setContrasena(cliente.getContrasena());
            clienteResultado = this.clienteRepository.save(clienteResultado);
        }
        return clienteResultado;
    }
    public void delete(Long id){
        this.clienteRepository.deleteById(id);
    }
}
