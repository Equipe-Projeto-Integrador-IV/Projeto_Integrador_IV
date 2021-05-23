package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListarUsuarios extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    ListView lstCliente;
    ClienteDAO Cdao;
    Button btnVoltar_TelaListarUsuarios;
    TextView listar;
    List<Cliente> listaCliente = new ArrayList<>();
    int indice;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        btnVoltar_TelaListarUsuarios = findViewById(R.id.btnServicoVoltarListar);
        btnVoltar_TelaListarUsuarios.setOnClickListener(this);
        Cdao = new ClienteDAO(this);
        lstCliente = findViewById(R.id.listView_ServicoLISTAR);
        lstCliente.setOnItemClickListener(this);
        atualizarLista();



    }

    private void atualizarLista(){

        listaCliente = Cdao.list();
        listAdapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, listaCliente);

        lstCliente.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltar_TelaListarUsuarios){
            Intent telaRetornarListarUsuario = new Intent(this, TelaPainelControle.class);
            startActivity(telaRetornarListarUsuario);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}