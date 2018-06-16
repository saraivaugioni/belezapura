package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Atendimento;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AtendimentoService extends AbstractCrudService<Atendimento> {

    @Inject
    private GenericDao<Atendimento> dao;

    @Override
    protected GenericDao<Atendimento> getDao() {
        return dao;
    }
}