package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Protocolo;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.ProtocoloService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("protocolos")
public class ProtocoloResource extends AbstractCrudResource<Protocolo> {

    @Inject
    private ProtocoloService service;

    @Override
    protected AbstractCrudService<Protocolo> getService() {
        return service;
    }

    /*@Inject
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
    }*/
}