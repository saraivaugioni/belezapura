package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Produto;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoService extends AbstractCrudService<Produto> {

    @Inject
    private GenericDao<Produto> dao;

    @Override
    protected GenericDao<Produto> getDao() {
        return dao;
    }
}