package com.ugioni.belezapura.utils;

import com.ugioni.belezapura.model.Equipamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenericDaoTest {

    private GenericDao<Equipamento> genericDao = new GenericDao(entityManager(), Equipamento.class);

    private EntityManager entityManager() {
        EntityManager mock = mock(EntityManager.class);
        when(mock.find(any(), any())).thenReturn(equipamento("Equipamento"));
        when(mock.merge(any())).thenReturn(equipamento("Equipamento update"));
        return mock;
    }

    private Equipamento equipamento(String descricao) {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(1L);
        equipamento.setDescricao(descricao);
        return equipamento;
    }

    @Test
    @DisplayName("Testando insert")
    public void testInsert() {
        Equipamento equipamento = genericDao.insert(equipamento("Equipamento"));
        assertEquals(equipamento.getDescricao(), "Equipamento");
    }

    @Test
    @DisplayName("Testando find")
    public void testFind() {
        assertNotNull(genericDao.find(1L));
    }

    @Test
    @DisplayName("Testando update")
    public void testUpdate() {
        Equipamento equipamento = equipamento("Equipamento");
        equipamento.setDescricao("Equipamento update");
        Equipamento equipamentoUpdate = genericDao.update(equipamento);
        assertEquals(equipamentoUpdate.getDescricao(), "Equipamento update");
    }
}