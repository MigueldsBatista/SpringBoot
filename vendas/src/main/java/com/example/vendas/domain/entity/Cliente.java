package com.example.vendas.domain.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Table(name="cliente", schema="vendas")
@Entity
public class Cliente {
    
    @Id//JPA identificador do campo ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")//opcional
    private Integer id;

    @Column(name="nome", length = 100)
    private String nome;

    public Cliente() {
        
    }

   public Cliente(Integer id, String nome){
    this.nome=nome;
    this.id=id;
   }
    //Métodos getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString(){
        return "Cliente{"+
                "id="+id+
                "nome="+nome+'\''+
                '}';
    }

}
    
    
