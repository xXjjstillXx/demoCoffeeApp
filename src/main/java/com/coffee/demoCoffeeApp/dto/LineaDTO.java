package com.coffee.demoCoffeeApp.dto;

import java.math.BigDecimal;

import lombok.Data;


@Data
public class LineaDTO {
    private Long lineaid;

	private Integer cantidad;

	private String descripcion;

	private BigDecimal precio;
}
