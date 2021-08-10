package com.bdoo.Resource;

import com.bdoo.dto.PasajeroDTO;
import com.bdoo.model.Pasajero;
import com.bdoo.services.PasajeroService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aeropuerto")
public class PasajeroResource {

    private static String NOT_FOUND = "No existe ese pasajero registrado";

    @Inject
    PasajeroService pasajeroService;

    @GET
    @Path("pasajero/{id_pasajero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPasajero(@PathParam("id_pasajero") Long id_pasajero) {

        PasajeroDTO pasajeroDTO = pasajeroService.getPasajero(id_pasajero);
        if (pasajeroDTO == null) {
            return Response.status(404).entity(NOT_FOUND).build();
        }
        return Response.status(200).entity(pasajeroDTO).build();
    }

    @GET
    @Path("pasajero/all/{paginacionInicio}/{longituPagina}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPasajeros(@PathParam("paginacionInicio") Integer paginacionInicio, @PathParam("longituPagina") Integer longituPagina) {

        return Response.status(200).entity(pasajeroService.getAll(paginacionInicio, longituPagina)).build();
    }


    @POST
    @Path("/pasajero")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPasajero(Pasajero pasajero) {
        return Response.status(200).entity(pasajeroService.persist(pasajero)).build();
    }

    @PUT
    @Path("/pasajero")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarPasajero(Pasajero pasajero) {
        return Response.status(200).entity(pasajeroService.update(pasajero)).build();
    }

    @DELETE
    @Path("/pasajero/{id_pasajero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePasajero(@PathParam("id_pasajero") Long id_pasajero) {
        return Response.status(200).entity(pasajeroService.delete(id_pasajero)).build();
    }
}
