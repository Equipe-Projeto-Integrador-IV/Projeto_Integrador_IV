package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPainelControle extends AppCompatActivity implements View.OnClickListener{

    Button btn_PainCadUsu;
    Button btn_PainVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_painel_controle);


        btn_PainCadUsu = findViewById(R.id.btnPainelCliente);
        btn_PainCadUsu.setOnClickListener(this);
        btn_PainVoltar = findViewById(R.id.btnPainelVoltar);
        btn_PainVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btn_PainVoltar){
            Intent tela = new Intent(this, TelaLogin.class);
            startActivity(tela);
        }
        if(v==btn_PainCadUsu){
            Intent tela2 = new Intent(this, TelaCadastroUsuario.class);
            startActivity(tela2);
        }

    }
}