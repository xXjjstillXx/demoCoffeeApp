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

import com.coffee.demoCoffeeApp.model.FacturacionModel;
import com.coffee.demoCoffeeApp.services.FacturacionService;



@RequestMapping(path = "api/facturacion")
@RestController
public class FacturacionController {
    
    @Autowired
    private FacturacionService facturacionService;

    @PostMapping("/crear")
    public ResponseEntity<FacturacionModel> create (@RequestBody FacturacionModel facturacion){
        return new ResponseEntity<>(this.facturacionService.create(facturacion),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.facturacionService.findById(id),HttpStatus.OK);
    }
}
