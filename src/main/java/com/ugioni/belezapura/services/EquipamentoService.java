package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Equipamento;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EquipamentoService extends AbstractCrudService<Equipamento> {

    @Inject
    private GenericDao<Equipamento> dao;

    @Override
    protected GenericDao<Equipamento> getDao() {
        return dao;
    }
}