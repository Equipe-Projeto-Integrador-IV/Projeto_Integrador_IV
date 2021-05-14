package com.example.projeto_integrador_iv.Models;

public class Servico {
    private Long id_servico;
    private String nome;
    private String descricao;
    private Float precoCusto;
    private Float precoVenda;

    public Servico() {

    }

    public Servico(Long id_servico, String nome, Float precoCusto, Float precoVenda) {
        this.id_servico = id_servico;
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public Long getIdServico() {
        return id_servico;
    }

    public void setIdServico(Long id_servico) {
        this.id_servico = id_servico;
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
        return "ID: " + getIdServico() + "\n" + " Nome: " + getNome() + "\n " +
                "Descrição: " + getDescricao() + "\n " + "Preço-Custo: " + getPrecoCusto() + "\n " +
                "Preço-Venda: " + getPrecoVenda();
    }
}
