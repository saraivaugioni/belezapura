package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Equipamento;
import com.ugioni.belezapura.utils.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EquipamentoService extends AbstractCrudService<Equipamento> {

    @Inject
    private GenericDao<Equipamento> dao;

    @Override
    protected GenericDao<Equipamento> getDao() {
        return dao;
    }

    /*@PersistenceContext
    private EntityManager em;

    public List<Equipamento> findAll() {
        Query query = em.createQuery("SELECT e FROM Equipamento AS e", Equipamento.class);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Equipamento insert(@Valid Equipamento equipamento) {
        em.persist(equipamento);
        return equipamento;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Equipamento update(@Valid Equipamento equipamento) {
        return em.merge(equipamento);
    }

    public Equipamento findById(Long id) {
        return em.find(Equipamento.class, id);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response remove(Long id) {
        Equipamento equipamento = em.getReference(Equipamento.class, id);
        em.remove(equipamento);
        return Response.noContent().build();
    }*/
}