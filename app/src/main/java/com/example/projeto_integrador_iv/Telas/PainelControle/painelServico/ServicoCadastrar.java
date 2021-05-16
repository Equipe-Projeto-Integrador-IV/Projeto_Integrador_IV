package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class ServicoCadastrar extends AppCompatActivity implements View.OnClickListener {


    Button btnServicoCadastrar_telaCadastro;
    Button btnServicoVoltar_telaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_cadastrar);


        btnServicoCadastrar_telaCadastro = findViewById(R.id.btnServicoCadastrarServicoCad);
        btnServicoCadastrar_telaCadastro.setOnClickListener(this);
        btnServicoVoltar_telaCadastro = findViewById(R.id.btnServicoVoltarServicoCad);
        btnServicoVoltar_telaCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnServicoCadastrar_telaCadastro){
            //IMPLEMENTAR METODO PARA CADASTRAR SERVIÇO QUANDO APERTA BOTAO CADASTRAR SERVIÇO
        }
        else if(v==btnServicoVoltar_telaCadastro){
            Intent telaRetornarPainel = new Intent(this, TelaPainelControle.class);
            startActivity(telaRetornarPainel);
        }

    }
}