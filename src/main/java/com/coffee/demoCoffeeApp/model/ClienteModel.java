package com.coffee.demoCoffeeApp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "clientes")
@NamedQuery(name="ClienteModel.findAll", query="SELECT c FROM ClienteModel c")
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
    public ClienteModel() {
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
  
}
