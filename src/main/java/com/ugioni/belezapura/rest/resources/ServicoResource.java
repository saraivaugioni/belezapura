package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Servico;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.ServicoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("servicos")
public class ServicoResource extends AbstractCrudResource<Servico> {

    @Inject
    private ServicoService service;

    @Override
    protected AbstractCrudService<Servico> getService() {
        return service;
    }
}