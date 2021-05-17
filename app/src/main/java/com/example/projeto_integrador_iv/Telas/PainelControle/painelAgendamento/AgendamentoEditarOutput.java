package com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;

public class AgendamentoEditarOutput extends AppCompatActivity implements View.OnClickListener {

    Button btnAgendamentoEditar_output_alterar;
    Button btnAgendamentoEditar_output_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_editar_output);


        btnAgendamentoEditar_output_alterar = findViewById(R.id.btnAgendamentoOutput_alterar);
        btnAgendamentoEditar_output_alterar.setOnClickListener(this);
        btnAgendamentoEditar_output_voltar = findViewById(R.id.btnAgendamentoOutput_voltar);
        btnAgendamentoEditar_output_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnAgendamentoEditar_output_alterar){

        }
        else if (v==btnAgendamentoEditar_output_voltar){
            Intent telaR = new Intent(this, AgendamentoEditarInput.class);
            startActivity(telaR);
        }

    }
}