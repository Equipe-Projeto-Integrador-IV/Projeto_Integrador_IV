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
import android.widget.Toast;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.dao.FuncionarioDAO;
import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class atv_lista_funcionario extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    ListView lstFuncionario;
//    Button btnCad;
    Button btnVoltar;

    List<Funcionario> listaFuncionario = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    FuncionarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_lista_funcionario);

//        btnCad = findViewById(R.id.btnCad);
//        btnCad.setOnClickListener(this);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        lstFuncionario = findViewById(R.id.lstFuncionario);
        lstFuncionario.setOnItemClickListener(this);

        dao = new FuncionarioDAO(this);

        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    protected void atualizarLista() {
        listaFuncionario = dao.list();
        listAdapter = new ArrayAdapter<Funcionario>(this, android.R.layout.simple_list_item_1, listaFuncionario);
        lstFuncionario.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == btnVoltar) {
            finish();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        indice = position;
        Funcionario funcionario = (Funcionario) lstFuncionario.getAdapter().getItem(position);
        Toast.makeText(this, " Funcionario: " + "\n" + funcionario + "\n" +
                " Telefone: " + funcionario.getTelefone() + "\n" +
                " Comissão: " + funcionario.getComissao(), Toast.LENGTH_SHORT).show();
//        abrirCadastro("Alterar", c);
    }

//    private void abrirCadastro(String acao, Cliente obj) {
//        Intent telaCad = new Intent(this, atv_cadastro_cliente.class);
//        Bundle extras = new Bundle();
//        extras.putString("acao", acao);
//        extras.putSerializable("obj", obj);
//        telaCad.putExtras(extras);
//        startActivity(telaCad);
//    }
}