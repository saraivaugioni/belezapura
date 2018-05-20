package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Cliente;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteService extends AbstractCrudService<Cliente> {

    @Inject
    private GenericDao<Cliente> dao;

    @Override
    protected GenericDao<Cliente> getDao() {
        return dao;
    }

   /* @PersistenceContext
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
    }*/
}