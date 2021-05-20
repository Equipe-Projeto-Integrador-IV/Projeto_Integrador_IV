package com.example.projeto_integrador_iv.models;
import java.io.Serializable;

public class Funcionario implements Serializable {

    private String cpf_funcionario;
    private String nome;
    private String senha;
    private String email;
    private String telefone;
    private Float comissao;

    public Funcionario() {

    }

    public Funcionario(String cpf_funcionario, String nome, String senha, String email, String telefone, Float comissao) {
        this.cpf_funcionario = cpf_funcionario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.comissao = comissao;
    }

    public String getCpfFuncionario() {
        return cpf_funcionario;
    }

    public void setCpfFuncionario(String cpf_funcionario) {
        this.cpf_funcionario = cpf_funcionario;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

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
        return "CPF: " + getCpfFuncionario() + "\n" + " Nome:" + getNome() + "\n" + " E-mail: " +
                getEmail() + "\n " + " Fone: " + getTelefone() + "\n " + " Comissão: " + getComissao();
    }
}
