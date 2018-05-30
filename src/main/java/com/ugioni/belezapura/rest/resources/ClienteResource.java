package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Cliente;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.ClienteService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("clientes")
public class ClienteResource extends AbstractCrudResource<Cliente> {

    @Inject
    private ClienteService service;

    @Override
    protected AbstractCrudService<Cliente> getService() {
        return service;
    }
}