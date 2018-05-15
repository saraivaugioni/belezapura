package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Produto;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoService {

    @PersistenceContext
    private EntityManager em;

    public List<Produto> findAll() {
        Query query = em.createQuery("SELECT p FROM Produto AS p", Produto.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Produto insert(@Valid Produto produto) {
        em.persist(produto);
        return produto;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Produto update(@Valid Produto produto) {
        return em.merge(produto);
    }

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(Long id) {
        Produto produto = em.getReference(Produto.class, id);
        em.remove(produto);
        return Response.noContent().build();
    }
}