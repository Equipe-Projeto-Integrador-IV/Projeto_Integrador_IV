package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener {


    Button btnLogin_logar;
    Button btnLogin_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);


        btnLogin_logar = findViewById(R.id.btn_LOGIN_entrar);
        btnLogin_logar.setOnClickListener(this);


        btnLogin_voltar = findViewById(R.id.btn_LOGIN_voltar);
        btnLogin_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnLogin_logar){
            //A SER IMPLEMENTANDO
        }
        else if(v==btnLogin_voltar){
            Intent telaVOltar = new Intent(this, MainActivity.class);
            startActivity(telaVOltar);
        }

    }
}