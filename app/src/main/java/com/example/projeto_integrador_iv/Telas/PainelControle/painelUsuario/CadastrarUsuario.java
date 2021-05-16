package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class CadastrarUsuario extends AppCompatActivity implements View.OnClickListener {

    Button btnVoltarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);


        btnVoltarUsuario = findViewById(R.id.btnCADASTRO_USU_voltar);
        btnVoltarUsuario.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltarUsuario){
            Intent telaVoltar = new Intent(this, TelaPainelControle.class);
            startActivity(telaVoltar);
        }

    }
}