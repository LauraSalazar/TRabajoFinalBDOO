package com.bdoo.services;

import com.bdoo.Repository.PasajeroRepository;
import com.bdoo.dto.PasajeroDTO;
import com.bdoo.model.Pasajero;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PasajeroService {

    @Inject
    PasajeroRepository pasajeroRepository;

    public PasajeroService() {

    }

    public PasajeroDTO getPasajero(Long id_Pasajero) {
        return pasajeroRepository.getPasajero(id_Pasajero);

    }

    public PasajeroDTO persist(Pasajero pasajero) {
        return pasajeroRepository.savePasajero(pasajero);
    }

    public PasajeroDTO update(Pasajero pasajero) {
        return pasajeroRepository.update(pasajero);
    }

    public String delete(Long id_pasajero) {
        return pasajeroRepository.deletePasajero(id_pasajero);
    }

    public List<PasajeroDTO> getAll(Integer paginacionInicio, Integer longituPagina) {
        return pasajeroRepository.getAll(paginacionInicio,longituPagina);
    }
}
