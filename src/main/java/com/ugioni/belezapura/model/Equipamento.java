package com.ugioni.belezapura.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "equipamentos")
public class Equipamento {

    @Id
    @Column(name = "id_equipamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "especificacao")
    private String especificacao;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "dataAquisicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAquisicao;

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipamento)) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getEspecificacao(), that.getEspecificacao()) &&
                Objects.equals(getPreco(), that.getPreco()) &&
                Objects.equals(getDataAquisicao(), that.getDataAquisicao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getEspecificacao(), getPreco(), getDataAquisicao());
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", preco=" + preco +
                ", dataAquisicao=" + dataAquisicao +
                '}';
    }
}