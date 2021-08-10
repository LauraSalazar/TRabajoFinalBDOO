package com.bdoo.services;

import com.bdoo.Repository.ReservaRepository;
import com.bdoo.dto.ReservaDTO;
import com.bdoo.model.Reserva;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReservaService {

    @Inject
    ReservaRepository reservaRepository;

    public ReservaDTO getReserva(Long id_Reserva) {
        return reservaRepository.getReserva(id_Reserva);

    }

    public ReservaDTO persist(Reserva reserva) {
        return reservaRepository.saveReserva(reserva);
    }

    public String delete(Long id_Reserva) { return reservaRepository.deleteReserva(id_Reserva);}
}
