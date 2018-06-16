package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Servico;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ServicoService extends AbstractCrudService<Servico> {

    @Inject
    private GenericDao<Servico> dao;

    @Override
    protected GenericDao<Servico> getDao() {
        return dao;
    }
}