package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicoEditarOutput extends AppCompatActivity implements View.OnClickListener{


    Button btnServicoVoltarOutput;
    Button btnServicoAlterarOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_editar_output);


        btnServicoVoltarOutput = findViewById(R.id.btnServicoVoltarOutput);
        btnServicoVoltarOutput.setOnClickListener(this);
        btnServicoAlterarOutput = findViewById(R.id.btnServicoAlterarOutput);
        btnServicoAlterarOutput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnServicoAlterarOutput){

        }

        else if(v == btnServicoVoltarOutput){
            Intent telaVolta = new Intent(this, ServicoEditarInput.class);
            startActivity(telaVolta);
        }

    }
}