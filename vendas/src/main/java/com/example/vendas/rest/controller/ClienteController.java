package com.example.vendas.rest.controller;


import java.util.List;

import org.springframework.data.domain.Example;

import org.springframework.data.domain.ExampleMatcher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.domain.repository.Clientes;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


//NAO PODEMOS APONTAR DOIS METODOS PARA MESMA URL!
//200 sucesso
//201 created
//404 not found

@RestController//similar a Controller, mas os metodos ja tem anotados com response body
@RequestMapping("/api/clientes/")
public class ClienteController {
    private Clientes clientes;

    ClienteController(Clientes clientes){
        this.clientes=clientes;
    }

    //ao inves de usar o Request mapping e especificar o get, posso usar direto o getMapping

    @GetMapping("{id}")   
    public Cliente getClienteById(@PathVariable Integer id){
        return clientes
                        .findById(id)
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")//404
            
        );
        
        
    }
    @PostMapping//root
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save( @RequestBody Cliente cliente){
        return clientes.save(cliente);

    }
    

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
                clientes.findById(id)
                        .map(cliente -> {
                        clientes.delete(cliente);
                        return Void.TYPE;
                        
                        })
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));//404

    }
    @PutMapping("{id}")//PUT mapping atualiza completamente um recurso existente
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
        @PathVariable Integer id,
        @RequestBody Cliente cliente){

        clientes
        .findById(id)
        .map(clienteExistente ->{
            cliente.setId(clienteExistente.getId());
            clientes.save(cliente);
            return clienteExistente;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));//404

    }
 
    @GetMapping//root
    public List<Cliente> find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                                                .matching()
                                                .withIgnoreCase()
                                                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
 
        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example); 

    }
    


}

 /*
 
 Outras formas de se trabalhar

 @RequestMapping(
value = "/hello/{nome}", //"home/{nome}",variavel na url, posso definir mais de um
method = RequestMethod.GET,
consumes={"application/json", "application/xml"},//opcional, posso decidir o tipo de dados que serao consumidos|JSON POR PADRAO
produces = {"application/json", "application/xml"}//opcional, posso decidir o tipo de dados que serao retornados|JSON POR PADRAO
        )//indica que isso vai ser o corpo do retorno | JSON por padrao
public String helloCliente(@PathVariable("nome") String nomeCliente){
return String.format("Hello %s", nomeCliente);

    }

         */