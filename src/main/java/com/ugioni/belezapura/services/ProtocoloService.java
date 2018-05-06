package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Protocolo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ProtocoloService {

    @PersistenceContext
    private EntityManager em;

    public List<Protocolo> findAll() {
        Query query = em.createQuery("SELECT p FROM Protocolo AS p", Protocolo.class);
        return query.getResultList();
    }

    public Protocolo insert(Protocolo protocolo) {
        em.persist(protocolo);
        return protocolo;
    }

    public Protocolo update(Protocolo protocolo) {
        return em.merge(protocolo);
    }

    public Protocolo findById(Long id) {
        return em.find(Protocolo.class, id);
    }

    public Response remove(Long id) {
        Protocolo protocolo = em.getReference(Protocolo.class, id);
        em.remove(protocolo);
        return Response.noContent().build();
    }
}