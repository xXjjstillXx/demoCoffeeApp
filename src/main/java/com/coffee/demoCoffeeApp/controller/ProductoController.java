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

import com.coffee.demoCoffeeApp.exceptions.ProductoException;
import com.coffee.demoCoffeeApp.model.ProductoModel;
import com.coffee.demoCoffeeApp.services.ProductoService;



@RequestMapping(path = "api/producto")
@RestController
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<String> create (@RequestBody ProductoModel producto) throws ProductoException{
        return new ResponseEntity<>(this.productoService.create(producto),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.productoService.findById(id),HttpStatus.OK);
    }
}

