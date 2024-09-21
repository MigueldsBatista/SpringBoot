package com.example.vendas.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.vendas.domain.entity.Pedido;
import com.example.vendas.domain.repository.Pedidos;
import com.example.vendas.domain.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private PedidoService service;
/*
 * GET pedidos (filtered)
 * POST pedido 
 * GET pedido by id
 * DELETE pedido by id
 * PUT pedido by id
 * 
 */

public PedidoController(PedidoService service){
    this.service=service;
}
 
}
