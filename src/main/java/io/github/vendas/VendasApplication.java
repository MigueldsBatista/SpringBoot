package io.github.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;//Isso aq garante que a  gnt vai seguir o protocolo https

@SpringBootApplication
@RestController//Segue os padroes https
public class VendasApplication {
    //Essa classe aq equivale as views
    @Autowired
    @Qualifier("applicationName")
    private String applicationName;


    @GetMapping("/hello")
    public String helloWorld() {
        return applicationName;
    }

    @GetMapping("/info")
    public String info() {
        return "Miguel Batista";
    }
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);

	}
    
}
