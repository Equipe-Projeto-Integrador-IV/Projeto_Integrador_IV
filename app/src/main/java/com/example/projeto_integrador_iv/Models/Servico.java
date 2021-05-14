package com.example.projeto_integrador_iv.Models;

import java.io.Serializable;

public class Servico implements Serializable {
    private Long id;
    private String nome;
    private String descricao;
    private Float precoCusto;
    private Float precoVenda;

    public Servico() {

    }

    public Servico(Long id, String nome, Float precoCusto, Float precoVenda) {
        this.id = id;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\n" + " Nome: " + getNome() + "\n " +
                "Descrição: " + getDescricao() + "\n " + "Preço-Custo: " + getPrecoCusto() + "\n " +
                "Preço-Venda: " + getPrecoVenda();
    }
}
