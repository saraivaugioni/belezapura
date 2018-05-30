package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Pacote;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PacoteService extends AbstractCrudService<Pacote> {

    @Inject
    private GenericDao<Pacote> dao;

    @Override
    protected GenericDao<Pacote> getDao() {
        return dao;
    }
}