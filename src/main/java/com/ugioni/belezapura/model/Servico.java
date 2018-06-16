package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "servicos")
public class Servico implements Entidade {

    @Id
    @Column(name = "id_servico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{Servico.descricao.NotNull}")
    @Size(max = 80, message = "{Servico.descricao.Size}")
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;

    @Size(max = 255, message = "{Servico.especificacao.Size}")
    @Column(name = "especificacao", length = 255)
    private String especificacao;

    @NotNull(message = "{Servico.valor.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{Servico.valor.Digits}")
    @Column(name = "valor", precision = 15, scale = 5)
    private BigDecimal valor;

    @Override
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Servico)) return false;
        Servico servico = (Servico) o;
        return Objects.equals(getId(), servico.getId()) &&
                Objects.equals(getDescricao(), servico.getDescricao()) &&
                Objects.equals(getEspecificacao(), servico.getEspecificacao()) &&
                Objects.equals(getValor(), servico.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getEspecificacao(), getValor());
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", valor=" + valor +
                '}';
    }
}