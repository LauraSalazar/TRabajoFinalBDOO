package com.bdoo.dto;

import com.bdoo.model.Reserva;

public class ReservaDTO {

    private String origen;
    private String destino;
    private String pasajero;
    private Long codigoVuelo;
    private Long id;
    private Double precio;

    public ReservaDTO(Reserva reserva) {
        this.setOrigen(reserva.vuelo.origen);
        this.setDestino(reserva.vuelo.destino);
        this.setPasajero(reserva.pasajero.nombre);
        this.setCodigoVuelo(reserva.vuelo.id);
        this.setId(reserva.id);
        this.setPrecio(reserva.precio);
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

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public Long getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(Long codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
