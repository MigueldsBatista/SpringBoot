package com.example.vendas.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")//opcional
    private Integer id;

    
    private String descricao;
    
    @Column(name="preco_unitario")//nao é o mesmo nome do db por isso eu uso
    private BigDecimal preco;
    

    public Produto(Integer id, String descricao, BigDecimal preco){
        this.id=id;
        this.descricao=descricao;
        this.preco=preco;
    }

    public Produto(){

    }
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
