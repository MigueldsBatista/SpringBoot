package com.example.vendas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @Column(name="data_pedido")
    private LocalDate dataPedido;

    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
