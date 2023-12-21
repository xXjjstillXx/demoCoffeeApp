package com.coffee.demoCoffeeApp.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "comprobante")
public class ComprobanteModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "cantidad")
    private Integer cantidad;

    @Column (name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column (name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @OneToMany(mappedBy="comprobante", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<LineaModel> lineas;

    public LineaModel addLinea(LineaModel linea) {
		getLineas().add(linea);
		linea.setComprobante(this);

		return linea;
	}

	public LineaModel removeLinea(LineaModel linea) {
		getLineas().remove(linea);
		linea.setComprobante(null);

		return linea;
	}

	// @Override
	// public String toString() {
	// 	StringBuilder builder = new StringBuilder();
	// 	builder.append("Comprobante [");
	// 	if (id != null)
	// 		builder.append("comprobanteid=").append(id).append(", ");
	// 	if (cantidad != null)
	// 		builder.append("cantidad=").append(cantidad).append(", ");
	// 	if (fechaCreacion != null)
	// 		builder.append("fechaCreacion=").append(fechaCreacion).append(", ");
	// 	if (valorTotal != null)
	// 		builder.append("total=").append(valorTotal).append(", ");
	// 	if (cliente != null)
	// 		builder.append("cliente=").append(cliente).append(", ");
	// 	if (lineas != null)
	// 		builder.append("lineas=").append(lineas);
	// 	builder.append("]");
	// 	return builder.toString();
	// }
    
    
    
}