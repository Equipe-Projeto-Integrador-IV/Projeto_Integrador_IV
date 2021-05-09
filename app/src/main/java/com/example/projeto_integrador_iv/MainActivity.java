package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCadastrar;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btn_Cadastrar);
        btnCadastrar.setOnClickListener(this);
        btnEntrar = findViewById(R.id.btn_Entrar);
        btnEntrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnCadastrar) {
            Intent telaCadastrar = new Intent(this, TelaCadastrarFuncionario.class);
            startActivity(telaCadastrar);
        }
        else if (v==btnEntrar){
            //AINDA A SER IMPLEMENTADO
        }

    }
}