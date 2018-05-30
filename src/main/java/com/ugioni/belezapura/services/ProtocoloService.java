package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Protocolo;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProtocoloService extends AbstractCrudService<Protocolo> {

    @Inject
    private GenericDao<Protocolo> dao;

    @Override
    protected GenericDao<Protocolo> getDao() {
        return dao;
    }
}