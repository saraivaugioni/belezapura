package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos")
public class Produto implements Entidade {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "codigo", length = 80, nullable = false)
    private String codigo;

    @NotNull
    @Size(max = 80)
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId()) &&
                Objects.equals(getCodigo(), produto.getCodigo()) &&
                Objects.equals(getDescricao(), produto.getDescricao()) &&
                Objects.equals(getPreco(), produto.getPreco()) &&
                Objects.equals(getQuantidade(), produto.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCodigo(), getDescricao(), getPreco(), getQuantidade());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}