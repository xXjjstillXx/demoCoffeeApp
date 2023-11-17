package com.coffee.demoCoffeeApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalles_facturaciones")
public class DetallesFacturacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "facturacion_id")
    private FacturacionModel facturacion;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel producto;

    @Column(name = "cantidad_productos")
    private Integer cantidadProductos;

    @Column
    private double total;

}

// CREATE TABLE `detalles_facturaciones` (
//   `id` int NOT NULL AUTO_INCREMENT,
//   `facturacion_id` int NOT NULL,
//   `producto_id` int NOT NULL,
//   `cantidad_productos` int NOT NULL,
//   `total` float NOT NULL,
//   PRIMARY KEY (`id`),
//   CONSTRAINT fk_facturacion_id FOREIGN KEY (facturacion_id) REFERENCES facturaciones(id),
//   CONSTRAINT fk_producto_id FOREIGN KEY (producto_id) REFERENCES productos(id)
// ); 