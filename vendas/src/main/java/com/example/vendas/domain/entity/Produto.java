package com.example.vendas.domain.entity;

import java.math.BigDecimal;

public class Produto {
    private Integer id;
    private String descricao;
    private BigDecimal preco;

    //Métodos getters

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
    //Métodos setters

    public void setId(Integer id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
