package com.coffee.demoCoffeeApp.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "ventas")
public class FacturacionModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;
    @Column (name = "fecha_creacion")
    private Date fechaCreacion;
    @Column (name = "valor_producto")
    private double valorProducto;
}