package com.coffee.demoCoffeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coffee.demoCoffeeApp.exceptions.ClienteException;
import com.coffee.demoCoffeeApp.model.ClienteModel;
import com.coffee.demoCoffeeApp.services.ClienteService;

@RestController
@RequestMapping(path = "api/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<String> create (@RequestBody ClienteModel cliente) throws ClienteException{
        return new ResponseEntity<>(this.clienteService.create(cliente),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.clienteService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) throws ClienteException{
        return new ResponseEntity<>(this.clienteService.delete(id), HttpStatus.OK);
    }

}
