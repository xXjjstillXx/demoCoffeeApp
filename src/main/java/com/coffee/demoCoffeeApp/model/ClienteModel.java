package com.coffee.demoCoffeeApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private String nombre;
    @Column 
    private String correo;
    @Column 
    private String contrasena;
    @Column 
    private boolean permisos;

    public boolean getPermisos(){
        return permisos;
    }

    public void setPermisos(boolean permisos){
        this.permisos = permisos;
    }
}
