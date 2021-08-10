package com.bdoo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Pasajero extends PanacheEntity {

    public String nombre;
    public String direccion;
    public String dni;

    public Pasajero() {
    }

    public Pasajero(String nombre, String direccion, String dni) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.dni = dni;
    }

}
