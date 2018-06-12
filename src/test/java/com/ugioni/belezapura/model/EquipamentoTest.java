package com.ugioni.belezapura.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class EquipamentoTest {

    private Equipamento equipamento() {
        Equipamento equipamento = new Equipamento();
        equipamento.setId(1L);
        equipamento.setDescricao("Heccus Turbo");
        equipamento.setEspecificacao("especificação 01");
        equipamento.setPreco(BigDecimal.TEN);
        equipamento.setDataAquisicao(new Date(2018, 1, 1));
        return equipamento;
    }

    @Test
    @DisplayName("Testando getId")
    public void testGetId() {
        assertTrue(equipamento().getId() == 1L);
    }

    @Test
    @DisplayName("Testando getDescricao")
    public void testGetDescricao() {
        assertEquals(equipamento().getDescricao(), "Heccus Turbo");
    }

    @Test
    @DisplayName("Testando getEspecificacao")
    public void testGetEspecificacao() {
        assertEquals(equipamento().getEspecificacao(), "especificação 01");
    }

    @Test
    @DisplayName("Testando getPreco")
    public void testGetPreco() {
        assertEquals(equipamento().getPreco(), BigDecimal.TEN);
    }

    @Test
    @DisplayName("Testando getDataAquisicao")
    public void testGetDataAquisicao() {
        assertEquals(equipamento().getDataAquisicao(), new Date(2018, 1, 1));
    }

    @Test
    @DisplayName("Testando toString")
    public void testToString() {
        assertNotNull(equipamento().toString());
    }

    @Test
    @DisplayName("Testando hashCode")
    public void testHashCode() {
        assertNotNull(equipamento().hashCode());
    }

    @Test
    @DisplayName("Testando equals")
    public void testEquals() {
        assertNotNull(equipamento().equals(equipamento()));
    }
}