package com.bdoo.Repository;

import com.bdoo.dto.ReservaDTO;
import com.bdoo.model.Aeropuerto;
import com.bdoo.model.Reserva;
import com.bdoo.model.Vuelo;
import io.agroal.api.AgroalDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ReservaRepository {

    @Inject
    AgroalDataSource dataSource;

    @Transactional
    public ReservaDTO getReserva(Long id_reserva) {
        ReservaDTO reservaDTO = null;
        Reserva reserva = Reserva.findById(id_reserva);
        if ( reserva != null) {
            reservaDTO = new ReservaDTO(reserva);
        }
        return reservaDTO;
    }

    @Transactional
    public ReservaDTO saveReserva(Reserva reserva) {
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        Vuelo vuelo = Vuelo.findById(reserva.vuelo.id);
        if(vuelo.cantidadActual < vuelo.cantidadMaxima) {
            vuelo.cantidadActual++;
            aeropuerto.reservas.add(reserva);
            Reserva.persist(reserva);
            Vuelo.persist(vuelo);
        }
        ReservaDTO reservaDTO = new ReservaDTO(reserva);
        return reservaDTO;
    }

    @Transactional
    public String deleteReserva(Long id_Reserva){
        Aeropuerto aeropuerto = Aeropuerto.findById(1l);
        Reserva reserva = Reserva.findById(id_Reserva);
        aeropuerto.reservas.remove(reserva);
        if (Reserva.deleteById(id_Reserva)) {
            return "Se elimino la serserva con codigo : " + id_Reserva;
        } else
            return "No se pudo eliminar la reserva : " + id_Reserva;
    }
}
