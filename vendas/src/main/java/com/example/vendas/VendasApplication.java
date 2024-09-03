package com.example.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import domain.entity.Cliente;
import domain.repository.Clientes;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.vendas", "domain.repository"})//fazer um scan manual
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){//injeção de Cliente
		//CMD
		return args -> {
			System.out.println("Salvando clientes... ");

			Cliente cliente = new Cliente(1, "Miguel");//instanciamos a classe
			clientes.salvar(cliente);
			Cliente cliente2 = new Cliente(2, "Yasmin");
			clientes.salvar(cliente2);

			List<Cliente> todosClientes=clientes.obterTodos();//parecido com uma lista encadeada
			todosClientes.forEach(System.out::println);
			System.out.println("Atualizando clientes... ");

			todosClientes.forEach(c ->{
				c.setNome(c.getNome()+" atualizado.");
				clientes.atualizar(c);

			});

			todosClientes=clientes.obterTodos();//parecido com uma lista encadeada
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes... ");
			List<Cliente> buscaNome=clientes.buscarPorNome("Miguel");
			buscaNome.forEach(System.out::println);

			System.out.println("Deletando clientes... ");
			clientes.obterTodos().forEach(c ->{
			clientes.deletar(c.getId());
			});

			todosClientes=clientes.obterTodos();
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
