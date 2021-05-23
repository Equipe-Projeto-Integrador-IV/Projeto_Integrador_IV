package com.example.projeto_integrador_iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_integrador_iv.models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements Dao<Funcionario> {

    private final String TABELA = "funcionario";

    private final String[] CAMPOS = {"cpf_funcionario, nome, email, senha, telefone, comissao"};

    private SQLiteDatabase banco;
    private Conexao conexao;

    public FuncionarioDAO(Context context){

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preencherValoresFuncionarios(Funcionario funcionario){
        ContentValues values = new ContentValues();

        values.put("cpf_funcionario",funcionario.getCpfFuncionario());
        values.put("nome",funcionario.getNome());
        values.put("senha", funcionario.getSenha());
        values.put("email",funcionario.getEmail());
        values.put("senha",funcionario.getSenha());
        values.put("telefone",funcionario.getTelefone());
        values.put("comissao", funcionario.getComissao());

        return values;
    }

    @Override
    public long insert(Funcionario funcionario) {
        ContentValues values = preencherValoresFuncionarios(funcionario);
        long funcionarioCad = banco.insert(TABELA, null, values);
        return funcionarioCad;
    }

    @Override
    public long update(Funcionario funcionario) {
        ContentValues values = preencherValoresFuncionarios(funcionario);
        long funcionarioUpdate =  banco.update(TABELA,
                values,
                "cpf_funcionario = ?",
                new String[]{String.valueOf(funcionario.getCpfFuncionario())});
        return funcionarioUpdate;
    }

    @Override
    public List<Funcionario> list() {
        Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

        List<Funcionario> lista = new ArrayList<>();
        while(c.moveToNext()){
            Funcionario funcionario = new Funcionario();
            funcionario.setCpfFuncionario(c.getString(0));
            funcionario.setNome(c.getString(1));
            funcionario.setEmail(c.getString(2));
            funcionario.setTelefone(c.getString(3));
            funcionario.setComissao(c.getString(4));
            lista.add(funcionario);

        }
        return lista;
    }

    @Override
    public long remove(Funcionario funcionario) {
        long funcionarioRemoved = banco.delete(TABELA,
                "cpf_funcionario = ?",
                new String[]{funcionario.getCpfFuncionario()});
        return funcionarioRemoved;
    }

    public Funcionario get(String cpf) {
        Cursor c = banco.query(TABELA, CAMPOS,
                "cpf_funcionario = ?", new String[] {String.valueOf(cpf)}, null, null, null);

        if (c.moveToNext()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpfFuncionario(c.getString(0));
            funcionario.setNome(c.getString(1));
            funcionario.setEmail(c.getString(2));
            funcionario.setTelefone(c.getString(3));
            funcionario.setComissao(c.getString(4));
            return funcionario;
        }
        else {
            return null;
        }
    }
}
