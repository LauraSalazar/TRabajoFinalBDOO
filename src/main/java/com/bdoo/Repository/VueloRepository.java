package com.bdoo.Repository;

import com.bdoo.dto.VueloDTO;
import com.bdoo.model.Aeropuerto;
import com.bdoo.model.Vuelo;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class VueloRepository {

    @Transactional
    public VueloDTO getVuelo(Long id_vuelo) {
        VueloDTO vueloDTO = null;
        Vuelo vuelo = Vuelo.findById(id_vuelo);
        if ( vuelo != null) {
            vueloDTO = new VueloDTO(vuelo);
        }
        return vueloDTO;
    }

    @Transactional
    public VueloDTO saveVuelo(Vuelo vuelo) {
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        aeropuerto.vuelos.add(vuelo);
        Vuelo.persist(vuelo);
        VueloDTO vueloDTO = new VueloDTO(vuelo);
        return vueloDTO;
    }

    @Transactional
    public VueloDTO update(Vuelo vuelo) {
        Vuelo vueloAPersistir = Vuelo.findById(vuelo.id);
        vueloAPersistir.cantidadActual = vuelo.cantidadActual;
        vueloAPersistir.cantidadMaxima = vuelo.cantidadMaxima;
        vueloAPersistir.origen = vuelo.origen;
        vueloAPersistir.destino = vuelo.destino;
        vueloAPersistir.horario = vuelo.horario;
        Vuelo.persist(vueloAPersistir);
        VueloDTO vueloDTO = new VueloDTO(vueloAPersistir);
        return vueloDTO;
    }

    @Transactional
    public String deleteVuelo(Long id_vuelo){
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        Vuelo vuelo = Vuelo.findById(id_vuelo);
        aeropuerto.vuelos.remove(vuelo);
        if (Vuelo.deleteById(id_vuelo)) {
            return "Se elimino el vuelo con codigo : " + id_vuelo;
        } else
            return "No se pudo eliminar el vuelo : " + id_vuelo + " el vuelo no existe o hay reservas asociadas";
    }

    @Transactional
    public Boolean hayLugar(Long id_vuelo) {
        Vuelo vuelo = Vuelo.findById(id_vuelo);
        return (vuelo.cantidadActual < vuelo.cantidadMaxima);
    }
}
