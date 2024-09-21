package com.example.vendas;
/* 
import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.domain.repository.Clientes;

import com.example.vendas.domain.entity.Pedido;
import com.example.vendas.domain.repository.Pedidos;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
*/
import org.springframework.boot.CommandLineRunner;
import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.domain.entity.Produto;
import com.example.vendas.domain.repository.Clientes;
import com.example.vendas.domain.repository.Produtos;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.example.vendas", "com.example.vendas.domain.repository"})//fazer um scan manual
public class VendasApplication {


	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Produtos produtos){
				return args->{
					Cliente c = new Cliente(null, "Fulano");
					clientes.save(c);
					Produto p = new Produto();
					p.setDescricao("caramelo");
					p.setPreco(BigDecimal.valueOf(100));
					
						
					};
				}

	/* 
    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ) {
        return args -> {
            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente(null, "Fulano");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);


//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());
			
			pedidos.findByCliente(fulano).forEach(System.out::println);


        };
	}
 */
	public static void main(String[] args) {//aq até agora so fica o run server
		SpringApplication.run(VendasApplication.class, args);
	}

}
