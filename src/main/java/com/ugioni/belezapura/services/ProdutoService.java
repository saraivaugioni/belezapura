package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Produto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ProdutoService {

    @PersistenceContext
    private EntityManager em;

    public List<Produto> findAll() {
        Query query = em.createQuery("SELECT p FROM Produto AS p", Produto.class);
        return query.getResultList();
    }

    public Produto insert(Produto produto) {
        em.persist(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        return em.merge(produto);
    }

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    public Response remove(Long id) {
        Produto produto = em.getReference(Produto.class, id);
        em.remove(produto);
        return Response.noContent().build();
    }
}