package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class ClienteService {

    @PersistenceContext
    private EntityManager em;

    public List<Cliente> findAll() {
        Query query = em.createQuery("SELECT c FROM Cliente AS c", Cliente.class);
        // TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente AS c", Cliente.class);
        return query.getResultList();
    }

    public Cliente insert(Cliente cliente) {
        em.persist(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente) {
        return em.merge(cliente);
    }

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public Response remove(Long id) {
        Cliente cliente = em.getReference(Cliente.class, id);
        em.remove(cliente);
        return Response.noContent().build();
    }


}