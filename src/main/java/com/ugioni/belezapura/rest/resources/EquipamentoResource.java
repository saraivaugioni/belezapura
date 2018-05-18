package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Equipamento;
import com.ugioni.belezapura.services.EquipamentoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("equipamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EquipamentoResource {

    @Inject
    private EquipamentoService service;

    @GET
    public Response findAll() {
        List<Equipamento> listaEquipamentos = service.findAll();
        return Response.ok(listaEquipamentos).build();
    }

    @POST
    public Response insert(Equipamento equipamento) {
        Equipamento inserido = service.insert(equipamento);
        return Response.ok(inserido).build();
    }

    @GET
    @Path("{id}")
    public Equipamento findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Equipamento equipamento) {
        return Response.ok(service.update(equipamento)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }
}