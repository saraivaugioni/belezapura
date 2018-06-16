package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoTest {

    private Servico servico() {
        Servico servico = new Servico();
        servico.setId(1L);
        servico.setDescricao("servico 01");
        servico.setEspecificacao("especificação 01");
        servico.setValor(BigDecimal.TEN);
        return servico;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(servico().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetDescricao() {
        assertEquals(servico().getDescricao(), "servico 01");
    }

    @Test
    @DisplayName("Testando getEspecificacao")
    public void testGetEspecificacao() {
        assertEquals(servico().getEspecificacao(), "especificação 01");
    }

    @Test
    @DisplayName("Testando getValor")
    public void testGetValorSecao() {
        assertEquals(servico().getValor(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(servico().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(servico().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(servico().equals(servico()));
    }
}