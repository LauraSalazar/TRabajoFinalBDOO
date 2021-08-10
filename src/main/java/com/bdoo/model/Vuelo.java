package com.bdoo.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Vuelo extends PanacheEntity {

    public Integer cantidadMaxima;
    public Integer cantidadActual;
    public String origen;
    public String destino;
    public String horario;

    public Vuelo() {

    }

}

