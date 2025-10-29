package com.recuperacao.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy=jakarta.persistence.GenerationType.IDENTITY)

    private Long id;
    private String cadastra;
    private String nome;
    private int quantidade;
    private double preco;
    private String descricao;
    private String categoria;


    public Long getId() {
        return id;
    }
    public void setCadastra(String cadastra) {
        this.cadastra = cadastra;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}

