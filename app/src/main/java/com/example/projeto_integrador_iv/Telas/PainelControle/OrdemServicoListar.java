package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrdemServicoListar extends AppCompatActivity implements View.OnClickListener{


    Button btn_OrdemServico_LISTAR_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_servico_listar);

        btn_OrdemServico_LISTAR_voltar = findViewById(R.id.btnOrdemServicoListar_VOLTAR);
        btn_OrdemServico_LISTAR_voltar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v==btn_OrdemServico_LISTAR_voltar){
            Intent telaListar = new Intent(this, TelaPainelControle.class);
            startActivity(telaListar);
        }

    }
}