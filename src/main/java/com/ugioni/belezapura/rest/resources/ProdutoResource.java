package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Produto;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.ProdutoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("produtos")
public class ProdutoResource extends AbstractCrudResource<Produto> {

    @Inject
    private ProdutoService service;

    @Override
    protected AbstractCrudService<Produto> getService() {
        return service;
    }

    /*@Inject
    private ProdutoService service;

    @GET
    public Response findAll() {
        List<Produto> listaProdutos = service.findAll();
        return Response.ok(listaProdutos).build();
    }

    @POST
    public Response insert(Produto produto) {
        Produto inserido = service.insert(produto);
        return Response.ok(inserido).build();
    }

    @GET
    @Path("{id}")
    public Produto findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Produto produto) {
        return Response.ok(service.update(produto)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }*/
}