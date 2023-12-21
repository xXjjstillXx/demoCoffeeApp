package com.coffee.demoCoffeeApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coffee.demoCoffeeApp.exceptions.ClienteException;
import com.coffee.demoCoffeeApp.exceptions.ComprobanteException;
import com.coffee.demoCoffeeApp.exceptions.ProductoException;



@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<String>handleClienteException(ClienteException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<String>handleProductoException(ProductoException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ComprobanteException.class)
    public ResponseEntity<String>handleProductoException(ComprobanteException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>("Error al leer el cuerpo de la solicitud: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
