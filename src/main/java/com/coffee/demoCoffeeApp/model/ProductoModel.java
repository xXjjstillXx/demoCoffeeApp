package com.coffee.demoCoffeeApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column 
    private String descripcion;
    @Column 
    private int cantidad;
    @Column 
    private double precio; 
    
}
