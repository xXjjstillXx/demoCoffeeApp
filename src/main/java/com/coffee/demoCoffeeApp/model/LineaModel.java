package com.coffee.demoCoffeeApp.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "linea")
@NamedQuery(name="LineaModel.findAll", query="SELECT l FROM LineaModel l")
public class LineaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "facturacion_id")
    private ComprobanteModel comprobante;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoModel producto;

    public LineaModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ComprobanteModel getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteModel comprobante) {
        this.comprobante = comprobante;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }
    


    // @Override
	// public String toString() {
	// 	StringBuilder builder = new StringBuilder();
	// 	builder.append("Linea [lineaid=").append(id).append(", cantidad=").append(cantidad).append(", ");
	// 	if (descripcion != null)
	// 		builder.append("descripcion=").append(descripcion).append(", ");
	// 	if (total != null)
	// 		builder.append("precio=").append(total);
	// 	builder.append("]");
	// 	return builder.toString();
	// }

    

    

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

