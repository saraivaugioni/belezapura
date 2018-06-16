package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PacoteTest {

    private Pacote pacote() {
        Pacote pacote = new Pacote();
        pacote.setId(1L);
        pacote.setCliente(new Cliente());
        pacote.setData(new Date(2018, 1, 1));
        pacote.setItens(new ArrayList<>());
        pacote.setValorTotal(BigDecimal.TEN);
        return pacote;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(pacote().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getCliente")
    public void testGetCliente() {
        assertNotNull(pacote().getCliente());
    }

    @Test
    @DisplayName("Testando getData")
    public void testGetData() {
        assertEquals(pacote().getData(), new Date(2018, 1, 1));
    }

    @Test
    @DisplayName("Testando getItens")
    public void testGetItens() {
        assertNotNull(pacote().getItens());
    }

    @Test
    @DisplayName("Testando getValorTotal")
    public void testGetValorTotal() {
        assertEquals(pacote().getValorTotal(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(pacote().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(pacote().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(pacote().equals(pacote()));
    }
}