package com.bdoo.services;

import com.bdoo.Repository.VueloRepository;
import com.bdoo.dto.VueloDTO;
import com.bdoo.model.Vuelo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class VueloService {

    @Inject
    VueloRepository vueloRepository;

    public VueloDTO getVuelo(Long id_Vuelo) {
        return vueloRepository.getVuelo(id_Vuelo);

    }

    public VueloDTO persist(Vuelo vuelo) {
        return vueloRepository.saveVuelo(vuelo);
    }

    public VueloDTO update(Vuelo vuelo) { return vueloRepository.update(vuelo);}

    public String delete(Long id_vuelo) { return vueloRepository.deleteVuelo(id_vuelo);}

    public Boolean hayLugar(Long id_vuelo) {return vueloRepository.hayLugar(id_vuelo);}
}
