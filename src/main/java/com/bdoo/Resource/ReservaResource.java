package com.bdoo.Resource;

import com.bdoo.dto.ReservaDTO;
import com.bdoo.model.Reserva;
import com.bdoo.services.ReservaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aeropuerto")
public class ReservaResource {

    private static String NOT_FOUND = "Reserva no encontrada";

    @Inject
    ReservaService reservaService;

    @GET
    @Path("/reserva/{id_reserva}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserva(@PathParam("id_reserva") Long id_reserva) {

        ReservaDTO reservaDTO = reservaService.getReserva(id_reserva);
        if (reservaDTO == null) {
            return Response.status(404).entity(NOT_FOUND).build();
        }
        return Response.status(200).entity(reservaDTO).build();
    }

    @POST
    @Path("/reserva")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReserva(Reserva reserva) {
        return Response.status(200).entity(reservaService.persist(reserva)).build();
    }

    @PUT
    @Path("/reserva")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarReserva(Reserva reserva) {
        return Response.status(200).entity(reserva).build();
    }

    @DELETE
    @Path("/reserva/{id_reserva}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReserva(@PathParam("id_reserva") Long id_reserva) {
        return Response.status(200).entity(reservaService.delete(id_reserva)).build();
    }
}
