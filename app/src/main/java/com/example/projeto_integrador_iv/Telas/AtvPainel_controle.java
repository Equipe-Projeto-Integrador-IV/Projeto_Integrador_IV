package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projeto_integrador_iv.R;

public class AtvPainel_controle extends AppCompatActivity implements View.OnClickListener{

    CardView cardCliente;
    CardView cardFuncionario;
    CardView cardServico;
    CardView cardAgendamento;
    CardView cardOrdemServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_painel_controle);

        cardCliente = findViewById(R.id.cardCliente);
        cardCliente.setOnClickListener(this);

        cardFuncionario = findViewById(R.id.cardFuncionario);
        cardFuncionario.setOnClickListener(this);

        cardServico = findViewById(R.id.cardServico);
        cardServico.setOnClickListener(this);

        cardAgendamento = findViewById(R.id.cardAgendamento);
        cardAgendamento.setOnClickListener(this);

        cardOrdemServico = findViewById(R.id.cardOrdemServico);
        cardOrdemServico.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == cardCliente) {
            Intent teste = new Intent(this, AtvCliente.class);
            startActivity(teste);
        }
    }
}