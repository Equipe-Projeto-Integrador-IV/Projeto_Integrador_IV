package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.Telas.TelaCadastrarFuncionario;
import com.example.projeto_integrador_iv.Telas.TelaLogin;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //EM PRODUÇO, TESTANDO....

    Button btnCadastrar;
    Button btnEntrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnEntrar = findViewById(R.id.btn_sign_in);
       btnEntrar.setOnClickListener(this);
//
        btnCadastrar = findViewById(R.id.cad_func_style);
        btnCadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v==btnCadastrar) {
            Intent telaCadastrar = new Intent(this, TelaCadastrarFuncionario.class);
            startActivity(telaCadastrar);
        }
        else if (v==btnEntrar){

            Intent telaEntrar = new Intent(this, TelaPainelControle.class);
            startActivity(telaEntrar);
        }


    }
}