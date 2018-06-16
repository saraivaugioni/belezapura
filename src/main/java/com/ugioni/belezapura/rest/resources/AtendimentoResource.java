package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Atendimento;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.AtendimentoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("atendimentos")
public class AtendimentoResource extends AbstractCrudResource<Atendimento> {

    @Inject
    private AtendimentoService service;

    @Override
    protected AbstractCrudService<Atendimento> getService() {
        return service;
    }
}