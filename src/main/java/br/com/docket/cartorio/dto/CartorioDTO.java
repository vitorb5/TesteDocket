package br.com.docket.cartorio.dto;

import java.io.Serializable;

public class CartorioDTO implements Serializable {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
