package com.bdoo.model;

import io.quarkus.agroal.DataSource;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aeropuerto extends PanacheEntity {

    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Vuelo> vuelos =new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    public List<Pasajero> pasajeros = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reserva> reservas = new ArrayList<>();

    public Aeropuerto() {
    }


}