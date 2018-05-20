package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Pacote;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PacoteService extends AbstractCrudService<Pacote> {

    @Inject
    private GenericDao<Pacote> dao;

    @Override
    protected GenericDao<Pacote> getDao() {
        return dao;
    }

    /*@PersistenceContext
    private EntityManager em;

    public List<Pacote> findAll() {
        Query query = em.createQuery("SELECT p FROM Pacote AS p", Pacote.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pacote insert(@Valid Pacote pacote) {
        em.persist(pacote);
        return pacote;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pacote update(@Valid Pacote pacote) {
        return em.merge(pacote);
    }

    public Pacote findById(Long id) {
        return em.find(Pacote.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(Long id) {
        Pacote pacote = em.getReference(Pacote.class, id);
        em.remove(pacote);
        return Response.noContent().build();
    }*/
}