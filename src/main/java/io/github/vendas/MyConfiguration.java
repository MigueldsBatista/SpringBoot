package io.github.vendas;
import org.springframework.boot.CommandLineRunner;
//https://docs.spring.io/spring-boot/appendix/application-properties/index.html
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")// aqui eu escolho meu ambiente de desenvolvimento
public class MyConfiguration {


    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO!!");
        };
    }
}
