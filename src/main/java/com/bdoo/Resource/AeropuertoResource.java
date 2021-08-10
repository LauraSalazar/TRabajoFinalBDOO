package com.bdoo.Resource;

import com.bdoo.model.Aeropuerto;
import com.bdoo.services.AeropuertoService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/aeropuerto")
public class AeropuertoResource {

    @Inject
    AeropuertoService aeropuertoService;

    @POST
    @Path("/crearAeropuerto")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearAeropuerto(Aeropuerto aeropuerto) {
        aeropuertoService.crearAeropuerto(aeropuerto);
        return Response.status(200).entity(aeropuerto.name).build();
    }


}
