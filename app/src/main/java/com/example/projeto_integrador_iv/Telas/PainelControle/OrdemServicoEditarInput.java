package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class OrdemServicoEditarInput extends AppCompatActivity implements View.OnClickListener{



    Button btnOrdemServicoEditarINPUT_procurar;
    Button btnOrdemServicoEditarINPUT_voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_servico_editar_input);

        btnOrdemServicoEditarINPUT_procurar = findViewById(R.id.btnOrdemServicoEditarInput_procurar);
        btnOrdemServicoEditarINPUT_procurar.setOnClickListener(this);
        btnOrdemServicoEditarINPUT_voltar = findViewById(R.id.btnOrdemServicoEditarInput_voltar);
        btnOrdemServicoEditarINPUT_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnOrdemServicoEditarINPUT_procurar){

            Intent telaPross = new Intent(this, OrdemServicoEditarOutput.class);
            startActivity(telaPross);

        }
        else if (v==btnOrdemServicoEditarINPUT_voltar){

            Intent telavoltar = new Intent(this, TelaPainelControle.class);
            startActivity(telavoltar);
        }

    }
}