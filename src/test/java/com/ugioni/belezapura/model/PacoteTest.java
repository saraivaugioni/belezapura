package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PacoteTest {

    private Pacote pacote() {
        Pacote pacote = new Pacote();
        pacote.setId(1L);
        pacote.setDescricao("pacote 01");
        pacote.setEspecificacao("especificação 01");
        pacote.setSecoes(1);
        pacote.setValorSecao(BigDecimal.TEN);
        pacote.setValorTotal(BigDecimal.TEN);
        return pacote;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(pacote().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetDescricao() {
        assertEquals(pacote().getDescricao(), "pacote 01");
    }

    @Test
    @DisplayName("Testando getEspecificacao")
    public void testGetEspecificacao() {
        assertEquals(pacote().getEspecificacao(), "especificação 01");
    }

    @Test
    @DisplayName("Testando getSecoes")
    public void testGetSecoes() {
        assertTrue(pacote().getSecoes() == 1);
    }

    @Test
    @DisplayName("Testando getValorSecao")
    public void testGetValorSecao() {
        assertEquals(pacote().getValorSecao(), BigDecimal.TEN);
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
}