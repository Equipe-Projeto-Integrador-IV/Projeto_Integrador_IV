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
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AtvCliente extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lstCliente;
    Button btnCad;

    List<Cliente> listaClientes = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    ClienteDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cliente);

        btnCad = findViewById(R.id.btnCad);
        btnCad.setOnClickListener(this);

        lstCliente = findViewById(R.id.lstCliente);
        lstCliente.setOnItemClickListener(this);

        dao = new ClienteDAO(this);

        atualizarLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    protected void atualizarLista() {
        listaClientes = dao.list();
        listAdapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, listaClientes);
        lstCliente.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCad) {
            Cliente c = new Cliente();
            abrirCadastro("Inserir", c);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice = position;
        Cliente c = (Cliente) lstCliente.getAdapter().getItem(position);
        abrirCadastro("Alterar", c);
    }

    private void abrirCadastro(String acao, Cliente obj) {
        Intent telaCad = new Intent(this, atv_cadastro_cliente.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", obj);
        telaCad.putExtras(extras);
        startActivity(telaCad);
    }
}