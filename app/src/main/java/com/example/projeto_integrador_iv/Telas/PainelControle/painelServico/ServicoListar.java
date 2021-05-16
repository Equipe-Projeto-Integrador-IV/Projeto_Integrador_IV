package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class ServicoListar extends AppCompatActivity implements View.OnClickListener{


    Button TelaservicoListar_Voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_listar);

        TelaservicoListar_Voltar = findViewById(R.id.btnServicoVoltarListar);
        TelaservicoListar_Voltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v==TelaservicoListar_Voltar){

            Intent VoltarPainel = new Intent(this, TelaPainelControle.class);
            startActivity(VoltarPainel);
        }


    }
}