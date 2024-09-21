package com.example.vendas.domain.service.impl;

import org.springframework.stereotype.Service;

import com.example.vendas.domain.repository.Pedidos;
import com.example.vendas.domain.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
    private Pedidos repository;

public PedidoServiceImpl(Pedidos repository){
    this.repository=repository;
}
}
