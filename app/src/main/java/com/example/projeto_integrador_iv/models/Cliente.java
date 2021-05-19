package com.example.projeto_integrador_iv.models;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String cpf_cliente;
    private String nome;
    private String telefone;
    private String email;
    private String uf;

    public Cliente() {

    }

    public Cliente(String cpf_cliente, String nome, String telefone, String email, String uf) {
        this.cpf_cliente = cpf_cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.uf = uf;
    }

    public String getCpfCliente() {
        return cpf_cliente;
    }

    public void setCpfCliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
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

    /*@Override
    public String toString() {
        return "CPF: " + getCpfCliente() + "\n" + " Nome: " + getNome() + "\n " +
                "Fone: " + getTelefone() + "\n " + "E-mail: " + getEmail() + "\n " +
                "UF: " + getUf();
    }
   */
}
