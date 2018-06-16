package com.ugioni.belezapura.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pacotes")
@SequenceGenerator(name = "pacotes_seq", sequenceName = "pacotes_seq", allocationSize = 1)
public class Pacote implements Entidade {

    @Id
    @Column(name = "id_pacote")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacotes_seq")
    private Long id;

    @NotNull(message = "{Pacote.cliente.NotNull}")
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @NotNull(message = "{Pacote.data.NotNull}")
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @JoinColumn(name = "id_pacote")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PacoteItem> itens;

    @NotNull(message = "{Pacote.valorTotal.NotNull}")
    @Digits(integer = 10, fraction = 5, message = "{Pacote.valorTotal.Digits}")
    @Column(name = "vl_total", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<PacoteItem> getItens() {
        return itens;
    }

    public void setItens(List<PacoteItem> itens) {
        this.itens = itens;
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
        Pacote that = (Pacote) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getCliente(), that.getCliente()) &&
                Objects.equals(getData(), that.getData()) &&
                Objects.equals(getItens(), that.getItens()) &&
                Objects.equals(getValorTotal(), that.getValorTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCliente(), getData(), getItens(), getValorTotal());
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", data=" + data +
                ", itens=" + itens +
                ", valorTotal=" + valorTotal +
                '}';
    }
}