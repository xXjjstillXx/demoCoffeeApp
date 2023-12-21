package com.coffee.demoCoffeeApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.demoCoffeeApp.dto.ClienteDTO;
import com.coffee.demoCoffeeApp.exceptions.ClienteException;
import com.coffee.demoCoffeeApp.model.ClienteModel;
import com.coffee.demoCoffeeApp.repository.ClienteRepository;
import com.coffee.demoCoffeeApp.validators.ClienteValidator;

// import org.json.JSONException;
// import org.json.JSONObject;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    ClienteValidator validacionCliente = new ClienteValidator();

    public String create(ClienteModel newCliente) throws ClienteException{
        validacionCliente.validarCliente(newCliente);
        this.clienteRepository.save(newCliente);
        return "Cliente creado exitosamente";
    }

    public List<ClienteModel> findAll(){
        return this.clienteRepository.findAll();
    }

    public ClienteDTO findById(Long id){
        ClienteDTO cliente = null;
        Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
        if(clienteBD.isPresent()){
            cliente = this.toDTO(clienteBD.get());
        }else{
            cliente = new ClienteDTO();
        }
        return cliente;
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

    // public String delete (Long id) throws ClienteException{
    //     validacionCliente.validarExistencia(id);
    //     this.clienteRepository.deleteById(id);
    //     return "Cliente eliminado exitosamente";
    // }
 
    public String delete (Long id){
        String resultado = "Cliente no encontrado en base de datos";
        if(this.clienteRepository.existsById(id)){
            this.clienteRepository.deleteById(id);
            resultado = "Cliente eliminado exitosamente";
        }
        return resultado;
    }

    private ClienteDTO toDTO(ClienteModel cliente){
    ClienteDTO dto = new ClienteDTO();
    dto.setId(cliente.getId());
    dto.setNombre(cliente.getNombre());
    dto.setCorreo(cliente.getCorreo());
    dto.setPermisos(cliente.getPermisos());
    return dto;
    }

    // public String findById(Long id){
    //     JSONObject resultado = null;
    //     Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
    //     if(clienteBD.isPresent()){
    //         ClienteModel c = clienteBD.get();
    //         String descripcionClient = "{ \n" + 
    //                                 "\"id\": " + c.getId() + "," + 
    //                                 "\"nombre\": " + "\"" +  c.getNombre()+ "\"" + "," + 
    //                                 "\"correo\": " + "\"" + c.getCorreo() + "\"" +
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
