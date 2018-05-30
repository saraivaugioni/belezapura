package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Pacote;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.PacoteService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pacotes")
public class PacoteResource extends AbstractCrudResource<Pacote> {

    @Inject
    private PacoteService service;

    @Override
    protected AbstractCrudService<Pacote> getService() {
        return service;
    }
}