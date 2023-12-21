package com.coffee.demoCoffeeApp.dto;

import jakarta.persistence.Column;

import lombok.Data;

@Data
public class ClienteDTO {
    @Column
    private Long id;
    @Column 
    private String nombre;
    @Column 
    private String correo;
    @Column 
    private boolean permisos;
}
