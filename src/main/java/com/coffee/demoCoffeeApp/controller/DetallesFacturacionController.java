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

import com.coffee.demoCoffeeApp.model.DetallesFacturacionModel;
import com.coffee.demoCoffeeApp.services.DetallesFacturacionService;

@RequestMapping(path = "api/detalleFacturacion")
@RestController
public class DetallesFacturacionController {
    
    @Autowired
    private DetallesFacturacionService detallesFacturacionService;

    @PostMapping("/crear")
    public ResponseEntity<DetallesFacturacionModel> create (@RequestBody DetallesFacturacionModel detalleFacturacion){
        return new ResponseEntity<>(this.detallesFacturacionService.create(detalleFacturacion),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.detallesFacturacionService.findById(id),HttpStatus.OK);
    }
}
