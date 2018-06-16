package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PacoteItemTest {

    private PacoteItem pacoteItem() {
        PacoteItem pacoteItem = new PacoteItem();
        pacoteItem.setId(1L);
        pacoteItem.setServico(new Servico());
        pacoteItem.setQuantidade(BigDecimal.TEN);
        pacoteItem.setValorUnitario(BigDecimal.ONE);
        pacoteItem.setValorTotal(BigDecimal.TEN);
        return pacoteItem;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(pacoteItem().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getServico")
    public void testGetServico() {
        assertNotNull(pacoteItem().getServico());
    }

    @Test
    @DisplayName("Testando getQuantidade")
    public void testGetQuantidade() {
        assertEquals(pacoteItem().getQuantidade(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando getValorUnitario")
    public void testGetValorUnitario() {
        assertEquals(pacoteItem().getValorUnitario(), BigDecimal.ONE);
    }

    @Test
    @DisplayName("Testando getValorTotal")
    public void testGetValorTotal() {
        assertEquals(pacoteItem().getValorTotal(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(pacoteItem().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(pacoteItem().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(pacoteItem().equals(pacoteItem()));
    }
}