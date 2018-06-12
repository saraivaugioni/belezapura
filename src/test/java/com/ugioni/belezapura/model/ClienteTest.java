package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Leandro Ugioni");
        cliente.setTelefone("48 9919 5252");
        cliente.setEmail("a@b.com.br");
        return cliente;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(cliente().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getNome")
    public void testGetNome() {
        assertEquals(cliente().getNome(), "Leandro Ugioni");
    }

    @Test
    @DisplayName("Testando getTelefone")
    public void testGetTelefone() {
        assertEquals(cliente().getTelefone(), "48 9919 5252");
    }

    @Test
    @DisplayName("Testando getEmail")
    public void testGetEmail() {
        assertEquals(cliente().getEmail(), "a@b.com.br");
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(cliente().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(cliente().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(cliente().equals(cliente()));
    }
}