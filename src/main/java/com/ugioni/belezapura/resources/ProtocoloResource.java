package com.ugioni.belezapura.resources;

import com.ugioni.belezapura.model.Protocolo;
import com.ugioni.belezapura.services.ProtocoloService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("protocolos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProtocoloResource {

    @Inject
    private ProtocoloService service;

    @GET
    public Response findAll() {
        List<Protocolo> listaProtocolos = service.findAll();
        return Response.ok(listaProtocolos).build();
    }

    @POST
    public Response insert(Protocolo protocolo) {
        Protocolo inserido = service.insert(protocolo);
        return Response.ok(inserido).build();
    }

    @GET
    @Path("{id}")
    public Protocolo findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Protocolo protocolo) {
        return Response.ok(service.update(protocolo)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }
}