package com.example.vendas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.domain.entity.Pedido;
import com.example.vendas.domain.entity.Cliente;
import java.util.List;


public interface Pedidos extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
    
}
