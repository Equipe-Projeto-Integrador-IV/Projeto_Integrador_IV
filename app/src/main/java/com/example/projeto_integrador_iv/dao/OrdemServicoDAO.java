package com.example.projeto_integrador_iv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.models.OrdemServico;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoDAO implements Dao<OrdemServico> {

    private final String TABELA = "ordem_servico";

    private final String[] CAMPOS = {"id_os, data_inicio , data_fim, hora_inicio, hora_fim, status, valor, id_agendamento_fk, id_servico_fk, cpf_funcionario_fk_os, cpf_funcionario_fk_servico"};

    private SQLiteDatabase banco;
    private Conexao conexao;
    private Context context;

    public OrdemServicoDAO(Context context){
        this.context = context;
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preencherValoresOrdemServico(OrdemServico ordemServico){
        ContentValues values = new ContentValues();

        values.put("id_os",ordemServico.getId_os());

        if(ordemServico.getData_inicio() != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String data_inicio = df.format(ordemServico.getData_inicio());
            values.put("data_inicio", data_inicio);
        }

        if(ordemServico.getData_fim() != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String data_fim = df.format(ordemServico.getData_fim());
            values.put("data_fim", data_fim);
        }

        if (ordemServico.getHora_inicio() != null) {
            DateFormat df = new SimpleDateFormat("hh:mm:ss a");
            String hora_inicio = df.format(ordemServico.getHora_inicio().getTime());
            values.put("hora_inicio", hora_inicio);
        }

        if (ordemServico.getHora_fim() != null) {
            DateFormat df = new SimpleDateFormat("hh:mm:ss a");
            String hora_fim = df.format(ordemServico.getHora_inicio().getTime());
            values.put("hora_fim", hora_fim);
        }

        values.put("status",ordemServico.getStatus());
        values.put("valor", ordemServico.getValor());

        if(ordemServico.getAgendamento() != null) {
            values.put("id_agendamento_fk", ordemServico.getAgendamento().getId());
        }

        if(ordemServico.getServico() != null) {
            values.put("id_servico_fk", ordemServico.getServico().getIdServico());
        }

        if(ordemServico.getRespOS() != null) {
            values.put("cpf_funcionario_fk_os", ordemServico.getRespOS().getCpfFuncionario());
        }

        if(ordemServico.getExecServico() != null) {
            values.put("cpf_funcionario_fk_servico", ordemServico.getExecServico().getCpfFuncionario());
        }

        return values;
    }

    @Override
    public long insert(OrdemServico ordemServico) {
        ContentValues values = preencherValoresOrdemServico(ordemServico);
        long insertOrdService = banco.insert(TABELA, null, values);
        ordemServico.setId_os(insertOrdService);
        return insertOrdService;
    }

    @Override
    public long update(OrdemServico ordemServico) {
        ContentValues values = preencherValoresOrdemServico(ordemServico);
        long updateOrdServico;
        updateOrdServico = banco.update(TABELA, values, "id_os = ?", new String[] {String.valueOf(ordemServico.getId_os())});
        return updateOrdServico;
    }

    @Override
    public List<OrdemServico> list() {
        Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

        List<OrdemServico> lista = new ArrayList<>();
        while(c.moveToNext()){
            OrdemServico ordemServico = new OrdemServico();
            ordemServico.setId_os(c.getLong(0));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                String data_inicio = c.getString(1);
                ordemServico.setData_inicio(df.parse(data_inicio));
            } catch (ParseException e) {
                ordemServico.setData_inicio(null);
                e.printStackTrace();
            }

            try {
                String data_fim = c.getString(2);
                ordemServico.setData_fim(df.parse(data_fim));
            } catch (ParseException e) {
                ordemServico.setData_fim(null);
                e.printStackTrace();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

            try {
                String hora_inicio = c.getString(3);
                ordemServico.setHora_inicio(sdf.parse(hora_inicio));
            } catch (ParseException e) {
                ordemServico.setHora_inicio(null);
                e.printStackTrace();
            }

            try {
                String hora_fim = c.getString(4);
                ordemServico.setHora_fim(sdf.parse(hora_fim));
            } catch (ParseException e) {
                ordemServico.setHora_fim(null);
                e.printStackTrace();
            }

            ordemServico.setStatus(c.getString(5));

           ordemServico.setAgendamento(new AgendamentoDAO(context).get(Long.valueOf(c.getString(6))));
           ordemServico.setServico(new ServicoDAO(context).get(Long.valueOf(c.getString(7))));
           ordemServico.setRespOS(new FuncionarioDAO(context).get(c.getString(8)));
           ordemServico.setExecServico(new FuncionarioDAO(context).get(c.getString(9)));

            lista.add(ordemServico);
        }
        return lista;
    }

    @Override
    public long remove(OrdemServico ordemServico) {
        long ordServiceRemoved = banco.delete(TABELA, "id_os = ?", new String[] {String.valueOf(ordemServico.getId_os())});
        return ordServiceRemoved;
    }

}

