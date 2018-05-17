package com.ugioni.belezapura.resources;

import com.ugioni.belezapura.model.Cliente;
import com.ugioni.belezapura.services.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    private ClienteService service;

    @GET
    public Response findAll() {
        List<Cliente> listaClientes = service.findAll();
        return Response.ok(listaClientes).build();
    }

    @POST
    public Response insert(Cliente cliente) {
        Cliente inserido = service.insert(cliente);
        return Response.ok(inserido).build();
    }

    @GET
    @Path("{id}")
    public Cliente findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Cliente cliente) {
        if (!id.equals(cliente.getId())) {
            throw new BadRequestException("Id do cliente diferente");
        }
        return Response.ok(service.update(cliente)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }
}