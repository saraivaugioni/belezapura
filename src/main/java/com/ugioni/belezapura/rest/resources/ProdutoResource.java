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
}