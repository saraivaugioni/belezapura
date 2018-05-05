package com.ugioni.belezapura.services;

import com.ugioni.belezapura.model.Equipamento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class EquipamentoService {

    @PersistenceContext
    private EntityManager em;

    public List<Equipamento> findAll() {
        Query query = em.createQuery("SELECT e FROM Equipamento AS e", Equipamento.class);
        return query.getResultList();
    }

    public Equipamento insert(Equipamento equipamento) {
        em.persist(equipamento);
        return equipamento;
    }

    public Equipamento update(Equipamento equipamento) {
        return em.merge(equipamento);
    }

    public Equipamento findById(Long id) {
        return em.find(Equipamento.class, id);
    }

    public Response remove(Long id) {
        Equipamento equipamento = em.getReference(Equipamento.class, id);
        em.remove(equipamento);
        return Response.noContent().build();
    }
}