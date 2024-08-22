package io.github.vendas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication


/*
caso eu fosse usar uma lib de terceiros essa seria uma forma de indicar ao container que eue estou usando esse pacote

@ComponentScan(basePackages =
{"io.github.vendas"},
{"io.github.vendas.repository"},)

*/
public class VendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
    @Value("${spring.application.name}")
    private String applicationName;

    @RestController
    public class HomeController {
    
        @GetMapping("/home")
        public String home() {
            return applicationName;
        }
    }
}
