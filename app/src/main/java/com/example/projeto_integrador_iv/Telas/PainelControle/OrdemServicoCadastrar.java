package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrdemServicoCadastrar extends AppCompatActivity implements View.OnClickListener{

    Button OrdemServico_Cadastrar_CADASTRAR;
    Button OrdemServico_Cadastrar_VOLTAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_servico_cadastrar);

        OrdemServico_Cadastrar_CADASTRAR = findViewById(R.id.btnOrdemServico_Cadastrar_CADASTRAR);
        OrdemServico_Cadastrar_CADASTRAR.setOnClickListener(this);

        OrdemServico_Cadastrar_VOLTAR = findViewById(R.id.btnOrdemServico_Cadastrar_VOLTAR);
        OrdemServico_Cadastrar_VOLTAR.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        if(v==OrdemServico_Cadastrar_CADASTRAR){

        }

        else if (v==OrdemServico_Cadastrar_VOLTAR){

            Intent voltarR = new Intent(this, TelaPainelControle.class);
            startActivity(voltarR);
        }

    }
}