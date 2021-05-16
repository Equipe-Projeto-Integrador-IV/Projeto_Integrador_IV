package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class ServicoEditarInput extends AppCompatActivity implements View.OnClickListener {

    Button voltar_TelaServioInput;
    Button procurar_TelaServicoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_editar_input);


        voltar_TelaServioInput = findViewById(R.id.btnServico_voltar_input);
        voltar_TelaServioInput.setOnClickListener(this);
        procurar_TelaServicoInput = findViewById(R.id.btnServico_Procurar_input);
        procurar_TelaServicoInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==voltar_TelaServioInput){

            Intent telaVoltarPainelControle = new Intent(this, TelaPainelControle.class);
            startActivity(telaVoltarPainelControle);
        }
        else if (v==procurar_TelaServicoInput){

            Intent telaEditarServicoOutput = new Intent(this, ServicoEditarOutput.class);
            startActivity(telaEditarServicoOutput);

        }

    }
}