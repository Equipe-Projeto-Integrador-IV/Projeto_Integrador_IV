package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

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
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Servico;

import java.util.ArrayList;
import java.util.List;

public class ServicoListar extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{



    ListView lstServico;
    ServicoDAO Sdao;
    Button btnServicoVoltarListar;
    TextView listar;
    List<Servico> listaServico = new ArrayList<>();
    int indice;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_listar);

        btnServicoVoltarListar = findViewById(R.id.btnServicoVoltarListar);
        btnServicoVoltarListar.setOnClickListener(this);


        Sdao = new ServicoDAO(this);
        lstServico = findViewById(R.id.listView_ServicoLISTAR);
        lstServico.setOnItemClickListener(this);
        atualizarLista();

    }

    private void atualizarLista(){

        listaServico = Sdao.list();
        listAdapter = new ArrayAdapter<Servico>(this, android.R.layout.simple_list_item_1, listaServico);

        lstServico.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {

        if (v==btnServicoVoltarListar){

            Intent VoltarPainel = new Intent(this, TelaPainelControle.class);
            startActivity(VoltarPainel);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}