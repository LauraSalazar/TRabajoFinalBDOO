package com.bdoo.services;

import com.bdoo.Repository.AeropuertoRepository;
import com.bdoo.dto.PasajeroDTO;
import com.bdoo.model.Aeropuerto;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class AeropuertoService {

    @Inject
    AeropuertoRepository aeropuertoRepository;

    AeropuertoService() {
    }

    public String crearAeropuerto(Aeropuerto aeropuerto){
        return aeropuertoRepository.crearAeropuerto(aeropuerto);
    }


}
