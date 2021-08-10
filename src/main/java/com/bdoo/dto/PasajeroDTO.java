package com.bdoo.dto;

import com.bdoo.model.Pasajero;

public class PasajeroDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String dni;

    public PasajeroDTO() {
        super();
    }

    public PasajeroDTO(Pasajero pasajero) {
        this.direccion = pasajero.direccion;
        this.nombre = pasajero.nombre;
        this.dni = pasajero.dni;
        this.id = pasajero.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
