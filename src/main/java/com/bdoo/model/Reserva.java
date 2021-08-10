package com.bdoo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reserva extends PanacheEntity {

    @ManyToOne
    public Vuelo vuelo;
    @ManyToOne
    public Pasajero pasajero;

    public Double precio;

    public Reserva() {

    }

    public Reserva(Vuelo vuelo, Pasajero pasajero) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;
    }

}
