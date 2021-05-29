package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

import com.example.projeto_integrador_iv.R;

public class AtvPainel_controle extends AppCompatActivity {

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
        cardFuncionario = findViewById(R.id.cardFuncionario);
        cardServico = findViewById(R.id.cardServico);
        cardAgendamento = findViewById(R.id.cardAgendamento);
        cardOrdemServico = findViewById(R.id.cardOrdemServico);
    }
}