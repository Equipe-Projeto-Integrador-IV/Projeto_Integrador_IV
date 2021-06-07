package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Float;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Servico;

import java.util.ArrayList;
import java.util.List;

public class atvServico extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener{

    ListView lstServico;
    Button btnCad;

    List<Servico> listaServicos = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    ServicoDAO dao;

    private void criarComponentes() {
        btnCad = findViewById(R.id.btnCad);
        btnCad.setOnClickListener(this);

        lstServico = findViewById(R.id.lstServico);
        lstServico.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_servico);

        criarComponentes();
        dao = new ServicoDAO(this);

        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    protected void atualizarLista() {
        listaServicos = dao.list();
        listAdapter = new ArrayAdapter<Servico>( this, android.R.layout.simple_list_item_1, listaServicos);
        lstServico.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCad) {
            Servico s = new Servico();
            s.setIdServico(1L);
            abrirCadastro("Inserir", s);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice = position;
        Servico s = (Servico) lstServico.getAdapter().getItem(position);
        abrirCadastro("Alterar", s);
    }

    private void abrirCadastro(String acao, Servico obj) {
        Intent telaCadServ = new Intent(this, atv_cadastro_servico.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaCadServ.putExtras(extras);
        startActivity(telaCadServ);
    }
}