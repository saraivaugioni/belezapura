package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Pacote;
import com.ugioni.belezapura.services.PacoteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("pacotes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacoteResource {

    @Inject
    private PacoteService service;

    @GET
    public Response findAll() {
        List<Pacote> listaPacotes = service.findAll();
        return Response.ok(listaPacotes).build();
    }

    @POST
    public Response insert(Pacote pacote) {
        Pacote inserido = service.insert(pacote);
        return Response.ok(inserido).build();
    }

    @GET
    @Path("{id}")
    public Pacote findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Pacote pacote) {
        return Response.ok(service.update(pacote)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }
}