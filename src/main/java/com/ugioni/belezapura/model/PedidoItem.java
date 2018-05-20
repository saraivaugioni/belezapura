package com.ugioni.belezapura.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "pedidos_itens")
@SequenceGenerator(name = "pedidos_itens_seq", sequenceName = "pedidos_itens_seq", allocationSize = 1)
public class PedidoItem implements Entidade {

    @Id
    @Column(name = "id_pedido_item")
    @GeneratedValue(generator = "pedidos_itens_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "vl_unitario", precision = 15, scale = 5)
    private BigDecimal valorUnitario;

    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @Column(name = "vl_total", precision = 15, scale = 5)
    private BigDecimal valorTotal;

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
        if (!(o instanceof PedidoItem)) return false;
        PedidoItem that = (PedidoItem) o;
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
        return "PedidoItem{" +
                "id=" + id +
                ", produto=" + produto +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                '}';
    }
}