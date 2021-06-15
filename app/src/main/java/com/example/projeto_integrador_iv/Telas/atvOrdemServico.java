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
import com.example.projeto_integrador_iv.dao.OrdemServicoDAO;
import com.example.projeto_integrador_iv.models.OrdemServico;
import com.example.projeto_integrador_iv.models.Servico;

import java.util.ArrayList;
import java.util.List;

public class atvOrdemServico extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    ListView lstOrdemServico;
    Button btnCad;
    Button btnVoltar;

    List<OrdemServico> listaOrdem = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    OrdemServicoDAO dao;

    private void criarComponentes() {
        btnCad = findViewById(R.id.btnCad);
        btnCad.setOnClickListener(this);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        lstOrdemServico = findViewById(R.id.lstOrdemServico);
        lstOrdemServico.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_ordem_servico);

        criarComponentes();
        dao = new OrdemServicoDAO(this);

        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    protected void atualizarLista() {
        listaOrdem = dao.list();
        listAdapter = new ArrayAdapter<OrdemServico>( this, android.R.layout.simple_list_item_1, listaOrdem);
        lstOrdemServico.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCad) {
            OrdemServico ord = new OrdemServico();
            ord.setId_os(1L);
            abrirCadastro("Inserir", ord);
        }else if (v == btnVoltar) {
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice = position;
        OrdemServico ord = (OrdemServico) lstOrdemServico.getAdapter().getItem(position);
        abrirCadastro("Alterar", ord);
    }

    private void abrirCadastro(String acao, OrdemServico obj) {
        Intent telaCadOrd = new Intent(this, atv_cadastro_ordem_servico.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaCadOrd.putExtras(extras);
        startActivity(telaCadOrd);
    }
}