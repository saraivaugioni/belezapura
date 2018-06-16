package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "atendimentos_itens")
@SequenceGenerator(name = "atendimentos_itens_seq", sequenceName = "atendimentos_itens_seq", allocationSize = 1)
public class AtendimentoItem implements Entidade {

    @Id
    @Column(name = "id_atendimento_item")
    @GeneratedValue(generator = "atendimentos_itens_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        if (!(o instanceof AtendimentoItem)) return false;
        AtendimentoItem that = (AtendimentoItem) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getProduto(), that.getProduto()) &&
                Objects.equals(getValorUnitario(), that.getValorUnitario()) &&
                Objects.equals(getQuantidade(), that.getQuantidade()) &&
                Objects.equals(getValorTotal(), that.getValorTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduto(), getValorUnitario(), getQuantidade(), getValorTotal());
    }

    @Override
    public String toString() {
        return "AtendimentoItem{" +
                "id=" + id +
                ", produto=" + produto +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}