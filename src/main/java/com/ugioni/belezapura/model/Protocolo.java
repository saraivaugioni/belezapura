package com.ugioni.belezapura.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "protocolos")
public class Protocolo {

    @Id
    @Column(name = "id_protocolo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "especificacao")
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