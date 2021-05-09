package com.example.projeto_integrador_iv.Models;

public class Funcionario {
    private String cpf;
    private String senha;
    private String email;
    private String telefone;
    private Float comissao;

    public Funcionario() {

    }

    public Funcionario(String cpf, String senha, String email, String telefone, Float comissao) {
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.comissao = comissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Float getComissao() {
        return comissao;
    }

    public void setComissao(Float comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf() + "\n" + " E-mail: " + getEmail() + "\n " +
                "Fone: " + getTelefone() + "\n " + "Comissão: " + getComissao();
    }
}
