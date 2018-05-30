package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Cliente;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteService extends AbstractCrudService<Cliente> {

    @Inject
    private GenericDao<Cliente> dao;

    @Override
    protected GenericDao<Cliente> getDao() {
        return dao;
    }
}