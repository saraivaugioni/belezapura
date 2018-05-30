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
}