package com.example.vendas.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Integer id;
    private Cliente cliente;
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
