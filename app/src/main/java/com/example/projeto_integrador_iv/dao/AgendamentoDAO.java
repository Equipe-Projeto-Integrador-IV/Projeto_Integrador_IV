package com.example.projeto_integrador_iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Cliente;


import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO implements Dao<Agendamento>{

    private final String TABELA = "agendamento";
    private final String[] CAMPOS = {"id, data, hora, status, observacao, cpf_cliente_fk_agendamento, cpf_funcionario_fk_agendamento, id_servico_fk_agendamento"};

    private SQLiteDatabase banco;
    private Conexao conexao;


    AgendamentoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }


    private ContentValues preencherValoresCliente(Agendamento agendamento){

        ContentValues values = new ContentValues();

        values.put("id", agendamento.getId());
        values.put("data", agendamento.getData().toString());
        values.put("hora", agendamento.getHora().getTime());
        values.put("status", agendamento.getStatus());
        values.put("observacao", agendamento.getObs());
        values.put("cpf_cliente_fk_agendamento", agendamento.getCliente().getCpfCliente());
        values.put("cpf_funcionario_fk_agendamento", agendamento.getRespAgendamento().getCpfFuncionario());
        values.put("id_servico_fk_agendamento", agendamento.getServico().getIdServico());


        return values;
    }



    @Override
    public long insert(Agendamento agendamento) {

        ContentValues values = preencherValoresCliente(agendamento);
        long agendamentoCad = banco.insert(TABELA, null, values);
        return agendamentoCad;
    }

    @Override
    public long update(Agendamento agendamento) {
        return 0;
    }




     @Override
     public List<Agendamento> list() {

         Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

         List<Agendamento> lista = new ArrayList<>();
         while(c.moveToNext()){
             Agendamento agendamento = new Agendamento();
             agendamento.setId(c.getLong(0));
             agendamento.setDate(new java.util.Date(c.getLong(1)));
             //new java.util.Date(c.getLong(8)
             lista.add(agendamento);
         }
         return lista;
     }

    @Override
    public long remove(Agendamento t) {
        return 0;
    }
}
