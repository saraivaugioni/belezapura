package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "pacotes_itens")
@SequenceGenerator(name = "pacotes_itens_seq", sequenceName = "pacotes_itens_seq", allocationSize = 1)
public class PacoteItem implements Entidade {

    @Id
    @Column(name = "id_pacote_item")
    @GeneratedValue(generator = "pacotes_itens_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "vl_unitario", precision = 15, scale = 5)
    private BigDecimal valorUnitario;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @NotNull
    @Digits(integer = 10, fraction = 5)
    @Column(name = "vl_total", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacoteItem)) return false;
        PacoteItem that = (PacoteItem) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getServico(), that.getServico()) &&
                Objects.equals(getValorUnitario(), that.getValorUnitario()) &&
                Objects.equals(getQuantidade(), that.getQuantidade()) &&
                Objects.equals(getValorTotal(), that.getValorTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getServico(), getValorUnitario(), getQuantidade(), getValorTotal());
    }

    @Override
    public String toString() {
        return "PacoteItem{" +
                "id=" + id +
                ", servico=" + servico +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}