package com.ugioni.belezapura.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "clientes")
@SequenceGenerator(name = "clientes_seq", allocationSize = 1)
public class Cliente implements Entidade {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_seq")
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Size(max = 20)
    @Column(name = "telefone", length = 20)
    private String telefone;

    @Email
    @Size(max = 80)
    @Column(name = "email", length = 80)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) &&
                Objects.equals(getNome(), cliente.getNome()) &&
                Objects.equals(getTelefone(), cliente.getTelefone()) &&
                Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getTelefone(), getEmail());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}