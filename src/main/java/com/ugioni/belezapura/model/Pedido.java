package com.ugioni.belezapura.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "dt_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEmissao;

    @Column(name = "dt_aprovacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAprovacao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PedidoItem> itens;

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

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId()) &&
                Objects.equals(getCliente(), pedido.getCliente()) &&
                Objects.equals(getDataEmissao(), pedido.getDataEmissao()) &&
                Objects.equals(getDataAprovacao(), pedido.getDataAprovacao()) &&
                Objects.equals(getItens(), pedido.getItens());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCliente(), getDataEmissao(), getDataAprovacao(), getItens());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataEmissao=" + dataEmissao +
                ", dataAprovacao=" + dataAprovacao +
                ", itens=" + itens +
                '}';
    }
}