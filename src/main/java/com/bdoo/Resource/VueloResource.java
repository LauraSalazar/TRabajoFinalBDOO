package com.bdoo.Resource;

import com.bdoo.dto.VueloDTO;
import com.bdoo.model.Pasajero;
import com.bdoo.model.Vuelo;
import com.bdoo.services.VueloService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aeropuerto")
public class VueloResource {

    private static String NOT_FOUND = "No existe el codigo de vuelo ingresado";

    @Inject
    VueloService vueloService;

    @GET
    @Path("/vuelo/{id_vuelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVuelo(@PathParam("id_vuelo") Long id_vuelo) {
        VueloDTO vueloDTO = vueloService.getVuelo(id_vuelo);
        if (vueloDTO == null) {
            return Response.status(404).entity(NOT_FOUND).build();
        }
        return Response.status(200).entity(vueloDTO).build();
    }

    @POST
    @Path("/vuelo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearVuelo(Vuelo vuelo)  {

        return Response.status(200).entity(vueloService.persist(vuelo)).build();
    }

    @PUT
    @Path("/vuelo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarVuelo(Vuelo vuelo) {
        return Response.status(200).entity(vueloService.update(vuelo)).build();
    }

    @DELETE
    @Path("/vuelo/{id_vuelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVuelo(@PathParam("id_vuelo") Long id_vuelo) {
        return Response.status(200).entity(vueloService.delete(id_vuelo)).build();
    }

    @GET
    @Path("/hayLugar/{id_vuelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hayLugar(@PathParam("id_vuelo") Long id_vuelo) {

        return Response.status(200).entity(vueloService.hayLugar(id_vuelo)).build();
    }
}
