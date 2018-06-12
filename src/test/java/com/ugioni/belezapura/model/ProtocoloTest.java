package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProtocoloTest {

    private Protocolo protocolo() {
        Protocolo protocolo = new Protocolo();
        protocolo.setId(1L);
        protocolo.setDescricao("Medida Certa");
        protocolo.setEspecificacao("Especificacao");
        return protocolo;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(protocolo().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetNome() {
        assertEquals(protocolo().getDescricao(), "Medida Certa");
    }

    @Test
    @DisplayName("Testando getEspecificacao")
    public void testGetTelefone() {
        assertEquals(protocolo().getEspecificacao(), "Especificacao");
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(protocolo().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(protocolo().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(protocolo().equals(protocolo()));
    }
}