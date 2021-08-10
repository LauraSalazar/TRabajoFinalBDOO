package com.bdoo.dto;

import com.bdoo.model.Vuelo;

public class VueloDTO {

    Long id;
    Integer cantidadMaxima;
    Integer cantidadActual;
    String origen;
    String destino;
    String horario;
    public VueloDTO(Vuelo vuelo) {
        this.setCantidadActual(vuelo.cantidadActual);
        this.setCantidadMaxima(vuelo.cantidadMaxima);
        this.setOrigen(vuelo.origen);
        this.setDestino(vuelo.destino);
        this.setHorario(vuelo.horario);
        this.setId(vuelo.id);
    }

    public Integer getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(Integer cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
