package com.coffee.demoCoffeeApp.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.coffee.demoCoffeeApp.model.ClienteModel;

import lombok.Data;

@Data
public class ComprobanteDTO {
    private Long comprobanteid;

	private Integer cantidad;

	private Date fecha;

	private BigDecimal total;

	private ClienteModel cliente;

	private Set<LineaDTO> lineas;
}
