package com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgendamentoDeletar extends AppCompatActivity implements View.OnClickListener{

    Button btnAgendamentoDeletar_excluir;
    Button btnAgendamentoDeletar_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_deletar);

        btnAgendamentoDeletar_excluir = findViewById(R.id.btnAgendamentoDeletar_DELETAR);
        btnAgendamentoDeletar_excluir.setOnClickListener(this);

        btnAgendamentoDeletar_voltar = findViewById(R.id.btnAgendamentoDeletar_VOLTAR);
        btnAgendamentoDeletar_voltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnAgendamentoDeletar_excluir){
        }
        else if (v==btnAgendamentoDeletar_voltar){

            Intent PainelVoltar = new Intent(this, TelaPainelControle.class);
            startActivity(PainelVoltar);

        }

    }
}