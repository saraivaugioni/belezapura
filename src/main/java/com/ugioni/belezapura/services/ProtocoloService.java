package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Protocolo;

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
public class ProtocoloService {

    @PersistenceContext
    private EntityManager em;

    public List<Protocolo> findAll() {
        Query query = em.createQuery("SELECT p FROM Protocolo AS p", Protocolo.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Protocolo insert(@Valid Protocolo protocolo) {
        em.persist(protocolo);
        return protocolo;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Protocolo update(@Valid Protocolo protocolo) {
        return em.merge(protocolo);
    }

    public Protocolo findById(Long id) {
        return em.find(Protocolo.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(Long id) {
        Protocolo protocolo = em.getReference(Protocolo.class, id);
        em.remove(protocolo);
        return Response.noContent().build();
    }
}