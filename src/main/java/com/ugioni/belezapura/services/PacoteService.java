package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Pacote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class PacoteService {

    @PersistenceContext
    private EntityManager em;

    public List<Pacote> findAll() {
        Query query = em.createQuery("SELECT p FROM Pacote AS p", Pacote.class);
        return query.getResultList();
    }

    public Pacote insert(Pacote pacote) {
        em.persist(pacote);
        return pacote;
    }

    public Pacote update(Pacote pacote) {
        return em.merge(pacote);
    }

    public Pacote findById(Long id) {
        return em.find(Pacote.class, id);
    }

    public Response remove(Long id) {
        Pacote pacote = em.getReference(Pacote.class, id);
        em.remove(pacote);
        return Response.noContent().build();
    }
}