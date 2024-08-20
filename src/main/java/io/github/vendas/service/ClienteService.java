package io.github.vendas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.vendas.model.Cliente;
import io.github.vendas.repository.ClienteRepository;

//Regras de negócio
@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository){//Um construtor
        this.repository = repository;
    }
    
    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);

        this.repository.salvar(cliente);

    }   

    public void validarCliente(Cliente cliente) {
        //aplica validações
    }
}
