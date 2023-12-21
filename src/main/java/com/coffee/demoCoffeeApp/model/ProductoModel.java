package com.coffee.demoCoffeeApp.model;

import java.math.BigDecimal;

import jakarta.persistence.*;



@Entity
@Table(name = "productos")
@NamedQuery(name="ProductoModel.findAll", query="SELECT p FROM ProductoModel p")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private String descripcion;
    @Column 
    private int cantidad;
    @Column 
    private BigDecimal precio; 

    public ProductoModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
}
