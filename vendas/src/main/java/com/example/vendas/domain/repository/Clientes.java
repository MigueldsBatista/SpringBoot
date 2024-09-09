package com.example.vendas.domain.repository;
import com.example.vendas.domain.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;


@Repository
public class Clientes {

    @Autowired
    private EntityManager entityManager;//faz as operações na base com nossas entidades

    //SEGUNDO parametro é um roll mapper 
    @Transactional(readOnly=true)
    public List<Cliente> buscarPorNome(String nome) {
        String SEARCH = "select c from Cliente c where c.nome like :nome";
// : -> parametro jpa
        TypedQuery<Cliente> query = entityManager.createQuery(SEARCH, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional(readOnly=true)
    public List<Cliente> obterTodos(){
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Transactional
    public void deleter(Cliente cliente){ //metodo void pois so precisamos deletar
        if(!entityManager.contains(cliente)){

            cliente = entityManager.merge(cliente);//sincroniza a entidade com o entity manager
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        deleter(cliente);
    }
 
    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);//agora usando entity manager para salvar
        return cliente;
    }
    @Transactional
    public Cliente atualizar(Cliente cliente){//sincroniza esse cliente com o nosso do banco de dados
        entityManager.merge(cliente);//atualizar uma entidade
        return cliente;     
    }


    

}
