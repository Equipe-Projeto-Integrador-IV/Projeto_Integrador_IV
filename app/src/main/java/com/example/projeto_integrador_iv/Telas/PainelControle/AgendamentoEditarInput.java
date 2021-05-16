package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgendamentoEditarInput extends AppCompatActivity implements View.OnClickListener{

    Button btnAgendamentoEditar_procurar;
    Button btnAgendamentoEditar_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_editar_input);

        btnAgendamentoEditar_procurar = findViewById(R.id.btnAgendamentoInput_procurar);
        btnAgendamentoEditar_procurar.setOnClickListener(this);
        btnAgendamentoEditar_voltar = findViewById(R.id.btnAgendamentoInput_voltar);
        btnAgendamentoEditar_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnAgendamentoEditar_procurar){
            Intent agendOut = new Intent(this, AgendamentoEditarOutput.class);
            startActivity(agendOut);
        }
        else if (v==btnAgendamentoEditar_voltar){
            Intent agendVoltar = new Intent(this, TelaPainelControle.class);
            startActivity(agendVoltar);
        }

    }
}