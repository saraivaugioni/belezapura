package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacoteTest {

    private Pacote pacote() {
        Pacote pacote = new Pacote();
        pacote.setId(1L);
        pacote.setDescricao("pacote 01");
        pacote.setEspecificacao("test");
        pacote.setSecoes(1);
        pacote.setValorSecao(BigDecimal.TEN);
        pacote.setValorTotal(BigDecimal.TEN);
        return pacote;
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetDescricao() {
        assertEquals(pacote().getDescricao(), "pacote 01");
    }
}