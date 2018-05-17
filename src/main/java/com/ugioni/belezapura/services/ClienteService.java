package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Cliente;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteService {

    @PersistenceContext
    private EntityManager em;

    public List<Cliente> findAll() {
        Query query = em.createQuery("SELECT c FROM Cliente AS c", Cliente.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Cliente insert(@Valid Cliente cliente) {
        em.persist(cliente);
        return cliente;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Cliente update(@Valid Cliente cliente) {
        Cliente original = em.getReference(Cliente.class, cliente.getId());
        if (original == null) {
            throw new EntityNotFoundException();
        }
        return em.merge(cliente);
    }

    public Cliente findById(Long id) {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente == null) {
            throw new EntityNotFoundException();
        }
        return cliente;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(Long id) {
        Cliente cliente = em.getReference(Cliente.class, id);
        if (cliente == null) {
            throw new EntityNotFoundException();
        }
        em.remove(cliente);
        return Response.noContent().build();
    }
}