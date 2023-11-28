package com.coffee.demoCoffeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.demoCoffeeApp.model.ClienteModel;
import com.coffee.demoCoffeeApp.services.ClienteService;

@RequestMapping(path = "api/cliente")
@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<ClienteModel> create (@RequestBody ClienteModel cliente){
        return new ResponseEntity<>(this.clienteService.create(cliente),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.clienteService.findById(id),HttpStatus.OK);
    }

}
