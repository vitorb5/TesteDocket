package br.com.docket.cartorio.model;

import javax.persistence.*;

@Entity
@Table(name = "CARTORIO")
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;

    @Column(name = "NOME")
    private String nome;

    public Cartorio(){

    }

    public Cartorio (Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Cartorio(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
