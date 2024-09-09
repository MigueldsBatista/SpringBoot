package com.example.vendas;
import org.springframework.context.annotation.Bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.domain.repository.Clientes;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.vendas", "com.example.vendas.domain.repository"})//fazer um scan manual
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){//injeção de Cliente
		//CMD
		return args -> {
			//limpar o terminal
			System.out.println("Salvando clientes... ");
			clientes.save(new Cliente(null, "Miguel"));
			clientes.save(new Cliente(null, "Miguel"));

			System.out.println("Buscando todos os clientes... ");
			
			
			List<Cliente> todosClientes=clientes.findAll();//parecido com uma lista encadeada
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes... ");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome()+" - Atualizado");
				clientes.save(c);
			});
			todosClientes=clientes.findAll();//parecido com uma lista encadeada
			todosClientes.forEach(System.out::println);


			System.out.println("Buscando clientes... ");
			List<Cliente> buscaNome=clientes.findByNomeLike("Miguel");
			buscaNome.forEach(System.out::println);

			boolean existe=clientes.existsByNome("Douglas");

			System.out.println("Existe cliente com nome Douglas? "+existe);
			System.out.println("Deletando clientes... ");
			clientes.findAll().forEach(c ->{
			clientes.delete(c);
			});

			todosClientes=clientes.findAll();
			if (todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");

			}
			else{
				todosClientes.forEach(System.out::println);
			}


		}; 
	}
 
	public static void main(String[] args) {//aq até agora so fica o run server
		SpringApplication.run(VendasApplication.class, args);
	}

}
