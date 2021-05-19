package com.example.projeto_integrador_iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_integrador_iv.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ConexaoDAO {


    private final String TABELA = "cliente";
    private final String[] CAMPOS = {"cpf_cliente, nome, telefone, email, uf"};

    private SQLiteDatabase banco;
    private Conexao conexao;

    public ConexaoDAO(Context context){

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //DAO REFERENTE AO CLIENTE

    //preencher do cliente
    private ContentValues preencherValoresCadastroCliente(Cliente cliente){

        ContentValues values = new ContentValues();
        values.put("cpf_cliente", cliente.getCpfCliente());
        values.put("nome", cliente.getNome());
        values.put("telefone", cliente.getTelefone());
        values.put("email", cliente.getEmail());
        values.put("uf", cliente.getUf());

        return values;
    }

    //inserir cliente no banco
    public long inserirCliente(Cliente cliente){

        ContentValues values = preencherValoresCadastroCliente(cliente);

        return banco.insert(TABELA, null, values);
    }



    //excluir cliente no banco
    public long excluir(Cliente cliente){

        return banco.delete(TABELA,"cpf_cliente=?", new String[]{cliente.getCpfCliente()});

    }
    //listar cliente no banco
    public List<Cliente>  listar(){
        Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

        List<Cliente> lista = new ArrayList<>();
        while(c.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setCpfCliente(c.getString(0));
            cliente.setNome(c.getString(1));
            cliente.setTelefone(c.getString(2));
            cliente.setEmail(c.getString(3));
            cliente.setUf(c.getString(4));
            lista.add(cliente);
        }
        return lista;
    }



}
