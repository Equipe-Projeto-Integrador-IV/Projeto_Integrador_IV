package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.AgendamentoDAO;
import com.example.projeto_integrador_iv.models.Agendamento;

import java.util.ArrayList;
import java.util.List;

public class atvAgendamento extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    ListView lstAgendamento;
    Button btnCad;

    List<Agendamento> listaAgendamento = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    AgendamentoDAO dao;

    private void criarComponentes() {
        btnCad = findViewById(R.id.btnCad);
        btnCad.setOnClickListener(this);

        lstAgendamento = findViewById(R.id.lstAgendamento);
        lstAgendamento.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_agendamento);

        criarComponentes();
        dao = new AgendamentoDAO(this);

        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    protected void atualizarLista() {
        listaAgendamento = dao.list();
        listAdapter = new ArrayAdapter<Agendamento>( this, android.R.layout.simple_list_item_1, listaAgendamento);
        lstAgendamento.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCad) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId(1L);
            abrirCadastro("Inserir", agendamento);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice = position;
        Agendamento agendamento = (Agendamento) lstAgendamento.getAdapter().getItem(position);
        abrirCadastro("Alterar", agendamento);
    }

    private void abrirCadastro(String acao, Agendamento obj) {
        Intent telaCadAgendamento = new Intent(this, atv_cadastro_agendamento.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaCadAgendamento.putExtras(extras);
        startActivity(telaCadAgendamento);
    }


}