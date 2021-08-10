package com.bdoo.Repository;

import com.bdoo.dto.PasajeroDTO;
import com.bdoo.model.Aeropuerto;
import com.bdoo.model.Pasajero;
import io.agroal.api.AgroalDataSource;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PasajeroRepository {

    @Inject
    AgroalDataSource dataSource;

    @Transactional
    public PasajeroDTO getPasajero(Long id_pasajero) {
        PasajeroDTO pasajeroDTO = null;
        Pasajero pasajero = Pasajero.findById(id_pasajero);
        if ( pasajero != null) {
            pasajeroDTO = new PasajeroDTO(pasajero);
        }
        return pasajeroDTO;
    }

    @Transactional
    public PasajeroDTO savePasajero(Pasajero pasajero) {
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        aeropuerto.pasajeros.add(pasajero);
        Pasajero.persist(pasajero);
        PasajeroDTO pasajeroDTO = new PasajeroDTO(pasajero);
        return pasajeroDTO;
    }

    @Transactional
    public PasajeroDTO update(Pasajero pasajero) {
        Pasajero pasajeroAPersistir = Pasajero.findById(pasajero.id);
        pasajeroAPersistir.dni = pasajero.dni;
        pasajeroAPersistir.direccion = pasajero.direccion;
        pasajeroAPersistir.nombre = pasajero.nombre;
        Pasajero.persist(pasajeroAPersistir);
        PasajeroDTO pasajeroDTO = new PasajeroDTO(pasajeroAPersistir);
        return pasajeroDTO;
    }

    @Transactional
    public String deletePasajero(Long id_pasajero){
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        Pasajero pasajero = Pasajero.findById(id_pasajero);
        aeropuerto.pasajeros.remove(pasajero);
        if (Pasajero.deleteById(id_pasajero)) {
            return "Se elimino el pasajero : " + id_pasajero;
        } else
        return "No se pudo eliminar el pasajero : " + id_pasajero + "El pasajero no existe o tiene reservas";
    }

    @Transactional
    public List<PasajeroDTO> getAll(Integer paginacionInicio, Integer longituPagina){

        Page page = new Page(paginacionInicio,longituPagina);
        List<Pasajero> pasajeros = Pasajero.findAll(Sort.by("id")).page(page).list();
        return (pasajeros.stream().map(pasajero -> new PasajeroDTO(pasajero)).collect(Collectors.toList()));
    }

}

