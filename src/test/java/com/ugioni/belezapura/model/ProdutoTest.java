package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private Produto produto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setCodigo("001");
        produto.setDescricao("Cera Depimel");
        produto.setPreco(BigDecimal.ONE);
        produto.setQuantidade(BigDecimal.TEN);
        return produto;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(produto().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getCodigo")
    public void testGetCodigo() {
        assertEquals(produto().getCodigo(), "001");
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetNome() {
        assertEquals(produto().getDescricao(), "Cera Depimel");
    }

    @Test
    @DisplayName("Testando getPreco")
    public void testGetPreco() {
        assertEquals(produto().getPreco(), BigDecimal.ONE);
    }

    @Test
    @DisplayName("Testando getQuantidade")
    public void testGetQuantidade() {
        assertEquals(produto().getQuantidade(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(produto().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(produto().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(produto().equals(produto()));
    }
}