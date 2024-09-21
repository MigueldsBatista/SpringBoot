package com.example.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.domain.entity.ItemPedido;



public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {

}
