package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;

public class OrdemServicoEditarOutput extends AppCompatActivity implements View.OnClickListener {

    Button btnOrdemServicoEDITAR_OUTPUT_alterar;
    Button btnOrdemServicoEDITAR_OUTPUT_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_servico_editar_output);

        btnOrdemServicoEDITAR_OUTPUT_alterar = findViewById(R.id.btnOrdemServicoOUTPUT_ALTERAR);
        btnOrdemServicoEDITAR_OUTPUT_alterar.setOnClickListener(this);
        btnOrdemServicoEDITAR_OUTPUT_voltar = findViewById(R.id.btnOrdemServicoOUTPUT_VOLTAR);
        btnOrdemServicoEDITAR_OUTPUT_voltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnOrdemServicoEDITAR_OUTPUT_alterar){

        }
        else if (v==btnOrdemServicoEDITAR_OUTPUT_voltar){
            Intent voltar = new Intent(this, OrdemServicoEditarInput.class);
            startActivity(voltar);
        }

    }
}