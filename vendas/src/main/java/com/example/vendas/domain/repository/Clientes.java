package com.example.vendas.domain.repository;
import com.example.vendas.domain.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//nao preciso colocar @Repository pois ele ja vai ser automatico pelo Jpa repository
public interface Clientes extends JpaRepository<Cliente, Integer>{//Primeiro parametro e o tipo da entidade e o segundo o tipo do ID

//ele identifica como select c from cliente where c.nome like :nome
public List<Cliente> findByNomeLike(String nome);//nome é uma convencão para o nome do parametro 

//import org.springframework.data.jpa.repository.Query;

//@Query(value="select c from Cliente c where c.nome like :nome or c.id = :id")
//public List<Cliente> encontrarNome(String nome);
//assim posso especificar a query que quero rodar
//tambem posso usar o parametro nativeQuery para fazer o select direto

public List<Cliente> findByNomeOrId(String nome, Integer id);//outra forma de fazer o filtro
    
public List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

public boolean existsByNome(String nome);

@Query(" select c from Cliente c left join fetch c.pedidos where c.id =:id ")
Cliente findClienteFetchPedidos(@Param("id") Integer id);
//me traz os clientes que possuem pedidos
}
