package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Pedido;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.PedidoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("pedidos")
public class PedidoResource extends AbstractCrudResource<Pedido> {

    @Inject
    private PedidoService service;

    @Override
    protected AbstractCrudService<Pedido> getService() {
        return service;
    }
}