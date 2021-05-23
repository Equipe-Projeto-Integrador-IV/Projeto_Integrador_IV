package com.example.projeto_integrador_iv.models;

import java.io.Serializable;

public class Servico implements Serializable {
    private Long id_servico;
    private String nome;
    private String descricao;
    private Float preco_custo;
    private Float preco_venda;

    public Servico() {

    }

   public Servico(Long id_servico, String nome, Float preco_custo, Float preco_venda) {
        this.id_servico = id_servico;
        this.nome = nome;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
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

    public Float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(Float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Float preco_venda) {
        this.preco_venda = preco_venda;
    }


    @Override
    public String toString() {
        return "Servico: \n" +
                "Id = " + id_servico  +"\n"+
                "Nome = " + nome + " \n" +
                "Descricao = " + descricao + "\n" +
                "Preço de Custo = " + preco_custo + "\n"+
                "Preco de Venda = " + preco_venda + "\n";
    }
}
