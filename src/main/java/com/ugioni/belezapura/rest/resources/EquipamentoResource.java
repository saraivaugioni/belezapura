package com.ugioni.belezapura.rest.resources;

import com.ugioni.belezapura.model.Equipamento;
import com.ugioni.belezapura.rest.AbstractCrudResource;
import com.ugioni.belezapura.services.AbstractCrudService;
import com.ugioni.belezapura.services.EquipamentoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("equipamentos")
public class EquipamentoResource extends AbstractCrudResource<Equipamento> {

    @Inject
    private EquipamentoService service;

    @Override
    protected AbstractCrudService<Equipamento> getService() {
        return service;
    }
}