package com.example.projeto_integrador_iv.Models;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String uf;

    public Cliente() {

    }

    public Cliente(String cpf, String nome, String telefone, String email, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.uf = uf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "CPF: " + getCpf() + "\n" + " Nome: " + getNome() + "\n " +
                "Fone: " + getTelefone() + "\n " + "E-mail: " + getEmail() + "\n " +
                "UF: " + getUf();
    }

}
