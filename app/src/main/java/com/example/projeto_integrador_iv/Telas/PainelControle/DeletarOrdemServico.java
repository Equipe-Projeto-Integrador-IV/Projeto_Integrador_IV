package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class DeletarOrdemServico extends AppCompatActivity implements View.OnClickListener {

    Button btnOrdemServicoDELETAR_deletar;
    Button btnOrdemServicoDELETAR_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_ordem_servico);

        btnOrdemServicoDELETAR_deletar=findViewById(R.id.btnOrdemServicoDELETAR_deletar);
        btnOrdemServicoDELETAR_deletar.setOnClickListener(this);

        btnOrdemServicoDELETAR_voltar = findViewById(R.id.btnOrdemServicoDELETAR_voltar);
        btnOrdemServicoDELETAR_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnOrdemServicoDELETAR_deletar){

        }
        else if (v==btnOrdemServicoDELETAR_voltar){

            Intent voltar = new Intent(this, TelaPainelControle.class);
            startActivity(voltar);
        }

    }
}