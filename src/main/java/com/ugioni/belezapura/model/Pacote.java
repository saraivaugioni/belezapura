package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "pacotes")
public class Pacote {

    @Id
    @Column(name = "id_pacote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;

    @Size(max = 255)
    @Column(name = "especificacao", length = 255)
    private String especificacao;

    @Column(name = "secoes")
    private Integer secoes;

    @Column(name = "valorSecao")
    private BigDecimal valorSecao;

    @Column(name = "valorTotal")
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public Integer getSecoes() {
        return secoes;
    }

    public void setSecoes(Integer secoes) {
        this.secoes = secoes;
    }

    public BigDecimal getValorSecao() {
        return valorSecao;
    }

    public void setValorSecao(BigDecimal valorSecao) {
        this.valorSecao = valorSecao;
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
        if (!(o instanceof Pacote)) return false;
        Pacote pacote = (Pacote) o;
        return Objects.equals(getId(), pacote.getId()) &&
                Objects.equals(getDescricao(), pacote.getDescricao()) &&
                Objects.equals(getEspecificacao(), pacote.getEspecificacao()) &&
                Objects.equals(getSecoes(), pacote.getSecoes()) &&
                Objects.equals(getValorSecao(), pacote.getValorSecao()) &&
                Objects.equals(getValorTotal(), pacote.getValorTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getEspecificacao(), getSecoes(), getValorSecao(), getValorTotal());
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", secoes=" + secoes +
                ", valorSecao=" + valorSecao +
                ", valorTotal=" + valorTotal +
                '}';
    }
}