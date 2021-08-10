package com.bdoo.Repository;

import com.bdoo.dto.PasajeroDTO;
import com.bdoo.model.Aeropuerto;
import com.bdoo.model.Pasajero;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class AeropuertoRepository {

    @Transactional
    public String crearAeropuerto(Aeropuerto aeropuerto) {

        Aeropuerto.persist(aeropuerto);
        return aeropuerto.name;
    }
}
