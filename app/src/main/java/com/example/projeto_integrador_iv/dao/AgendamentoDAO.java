package com.example.projeto_integrador_iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Cliente;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO implements Dao<Agendamento>{

    private final String TABELA = "agendamento";
    private final String[] CAMPOS = {"id, data, hora, status, observacao, cpf_cliente_fk_agendamento, cpf_funcionario_fk_agendamento, id_servico_fk_agendamento"};

    private SQLiteDatabase banco;
    private Conexao conexao;
    private Context context;

    public AgendamentoDAO(Context context){
        this.context = context;
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preencherValoresAgendamento(Agendamento agendamento) {

        ContentValues values = new ContentValues();

        if(agendamento.getData() != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String data = df.format(agendamento.getData());
            values.put("data", data);
        }

        if (agendamento.getHora() != null) {
            DateFormat df = new SimpleDateFormat("hh:mm:ss a");
            String hora = df.format(agendamento.getHora().getTime());
            values.put("hora", hora);
        }
        values.put("status", agendamento.getStatus());
        values.put("observacao", agendamento.getObs());

        if(agendamento.getCliente() != null){
        values.put("cpf_cliente_fk_agendamento", agendamento.getCliente().getCpfCliente());
        }

        if(agendamento.getRespAgendamento() != null) {
            values.put("cpf_funcionario_fk_agendamento", agendamento.getRespAgendamento().getCpfFuncionario());
        }

        if(agendamento.getServico() != null) {
            values.put("id_servico_fk_agendamento", agendamento.getServico().getIdServico());
        }

        return values;
    }

    @Override
    public long insert(Agendamento agendamento) {

        ContentValues values = preencherValoresAgendamento(agendamento);
        long insertAgendamento = banco.insert(TABELA, null, values);
        agendamento.setId(insertAgendamento);
        return insertAgendamento;
    }

    @Override
    public long update(Agendamento agendamento) {
        ContentValues values = preencherValoresAgendamento(agendamento);
        long agendamentoUpdate =  banco.update(TABELA,
                values,
                "id = ?",
                new String[]{String.valueOf(agendamento.getId())});
        return agendamentoUpdate;
    }

    @Override
    public List<Agendamento> list() {
        Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

        List<Agendamento> lista = new ArrayList<>();
        while(c.moveToNext()){
            Agendamento agendamento = new Agendamento();
            agendamento.setId(c.getLong(0));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                String data = c.getString(1);
                agendamento.setData(df.parse(data));
            } catch (ParseException e) {
                agendamento.setData(null);
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

            try {
                String hour = c.getString(2);
                agendamento.setHora(sdf.parse(hour));
            } catch (ParseException e) {
                agendamento.setHora(null);
                e.printStackTrace();
            }
            agendamento.setStatus(c.getString(3));
            agendamento.setObs(c.getString(4));
            agendamento.setCliente(new ClienteDAO(context).get(c.getString(5)));
            agendamento.setRespAgendamento(new FuncionarioDAO(context).get(c.getString(6)));
            agendamento.setServico(new ServicoDAO(context).get(c.getLong(7)));

            lista.add(agendamento);
        }
        return lista;
    }

    @Override
    public long remove(Agendamento agendamento) {
        long agendamentoRemoved = banco.delete(TABELA, "id = ?", new String[] {String.valueOf(agendamento.getId())});
        return agendamentoRemoved;
    }


    public List<Agendamento> list(Cliente cliente) {

         Cursor c = banco.query(TABELA, CAMPOS, "id = " + cliente.getCpfCliente(), null, null, null, null);

         List<Agendamento> lista = new ArrayList<>();
         while(c.moveToNext()){
             Agendamento agendamento = new Agendamento();
             agendamento.setId(c.getLong(0));
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             try {
                String data = c.getString(1);
                agendamento.setData(df.parse(data));
             } catch (ParseException e) {
                 agendamento.setData(null);
                 e.printStackTrace();
             }
             try {
                 String hour = c.getString(2);
                 agendamento.setHora(df.parse(hour));
             } catch (ParseException e) {
                 agendamento.setHora(null);
                 e.printStackTrace();
             }
             agendamento.setStatus(c.getString(3));
             agendamento.setObs(c.getString(4));
             agendamento.setCliente(new ClienteDAO(context).get(c.getString(5)));
             agendamento.setRespAgendamento(new FuncionarioDAO(context).get(c.getString(6)));
             agendamento.setServico(new ServicoDAO(context).get(c.getLong(7)));

             lista.add(agendamento);
         }
         return lista;
     }

    public Agendamento get(Long id) {
        Cursor c = banco.query(TABELA, CAMPOS,
                "id = ?", new String[] {String.valueOf(id)}, null, null, null);
        if (c.moveToNext()) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId(Long.valueOf(c.getString(0)));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                String data = c.getString(1);
                agendamento.setData(df.parse(data));
            } catch (ParseException e) {
                agendamento.setData(null);
                e.printStackTrace();
            }
            try {
                String hour = c.getString(2);
                agendamento.setHora(df.parse(hour));
            } catch (ParseException e) {
                agendamento.setHora(null);
                e.printStackTrace();
            }

            agendamento.setStatus(c.getString(3));
            agendamento.setObs(c.getString(4));
            agendamento.setCliente(new ClienteDAO(context).get(c.getString(5)));
            agendamento.setRespAgendamento(new FuncionarioDAO(context).get(c.getString(6)));
            agendamento.setServico(new ServicoDAO(context).get(c.getLong(7)));

           return agendamento;
        }
        else {
            return null;
        }
    }


}
