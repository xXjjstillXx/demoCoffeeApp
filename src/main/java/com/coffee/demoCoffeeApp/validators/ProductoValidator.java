package com.coffee.demoCoffeeApp.validators;

import java.math.BigDecimal;

import com.coffee.demoCoffeeApp.exceptions.ProductoException;
import com.coffee.demoCoffeeApp.model.ProductoModel;

public class ProductoValidator {
    public void validarProducto(ProductoModel producto) throws ProductoException{
        if(producto.getCantidad() < 0 || producto.getPrecio().compareTo(BigDecimal.ZERO) < 0){
            throw new ProductoException("Cantidad o precio no válidos");
        }
    }
}
