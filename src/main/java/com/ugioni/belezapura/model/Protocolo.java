package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "protocolos")
public class Protocolo implements Entidade {

    @Id
    @Column(name = "id_protocolo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{Protocolo.descricao.NotNull}")
    @Size(max = 80, message = "{Protocolo.descricao.Size}")
    @Column(name = "descricao", length = 80, nullable = false)
    private String descricao;

    @Size(max = 255, message = "{Protocolo.especificacao.Size}")
    @Column(name = "especificacao", length = 255)
    private String especificacao;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Protocolo)) return false;
        Protocolo protocolo = (Protocolo) o;
        return Objects.equals(getId(), protocolo.getId()) &&
                Objects.equals(getDescricao(), protocolo.getDescricao()) &&
                Objects.equals(getEspecificacao(), protocolo.getEspecificacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getEspecificacao());
    }

    @Override
    public String toString() {
        return "Protocolo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", especificacao='" + especificacao + '\'' +
                '}';
    }
}