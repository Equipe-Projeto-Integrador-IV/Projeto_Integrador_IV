package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;

public class AgendamentoListar extends AppCompatActivity implements View.OnClickListener{

    Button btnAgendamentoLista_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_listar);

        btnAgendamentoLista_voltar = findViewById(R.id.btnAgendamentoListar_voltar);
        btnAgendamentoLista_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v==btnAgendamentoLista_voltar){
            Intent voltar = new Intent(this, TelaPainelControle.class);
            startActivity(voltar);
        }

    }
}