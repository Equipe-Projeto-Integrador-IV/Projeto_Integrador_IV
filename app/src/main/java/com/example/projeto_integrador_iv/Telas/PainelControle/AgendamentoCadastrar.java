package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class AgendamentoCadastrar extends AppCompatActivity implements View.OnClickListener{


    Button AgendamentoCadastrar_cadastrar;
    Button AgendamentoCadastrar_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_cadastrar);


        AgendamentoCadastrar_cadastrar = findViewById(R.id.btnAgendamentoCad_cadastrar);
        AgendamentoCadastrar_cadastrar.setOnClickListener(this);
        AgendamentoCadastrar_voltar = findViewById(R.id.btnAgendamentoCad_voltar);
        AgendamentoCadastrar_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==AgendamentoCadastrar_cadastrar){

        }
        else if(v == AgendamentoCadastrar_voltar){
            Intent nReturn = new Intent(this, TelaPainelControle.class);
            startActivity(nReturn);
        }

    }
}