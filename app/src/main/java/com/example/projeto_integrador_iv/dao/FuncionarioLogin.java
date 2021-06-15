package com.example.projeto_integrador_iv.dao;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projeto_integrador_iv.models.Funcionario;

public class FuncionarioLogin {
    private final String CONFIG = "config";
    private final String KEY = "logado";
    private Context context;

    public FuncionarioLogin(Context context) {
        this.context = context;
    }

    public void RealizarLogin(String cpf) {
        SharedPreferences pref = context.getSharedPreferences(CONFIG, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("logado", cpf);
        editor.commit();
    }

    public void RealizarLogin(Funcionario funcionario) {
        RealizarLogin(funcionario.getCpfFuncionario());
    }

    public String logadoCpf() {
        SharedPreferences pref = context.getSharedPreferences(CONFIG, 0);
        String cpf = pref.getString(KEY, String.valueOf(0));
        return cpf == "" ? null : cpf;
    }

    public Funcionario logado() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(context);
        String cpf = logadoCpf();
        return cpf == null ? null : funcionarioDAO.get(cpf);
        
    }
    
    public void logout() {
        SharedPreferences pref = context.getSharedPreferences(CONFIG, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("logout", String.valueOf(0));
        editor.commit();
    }
}
