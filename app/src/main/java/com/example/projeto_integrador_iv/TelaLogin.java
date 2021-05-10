package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener {


    EditText edtLogin;
    EditText edtSenha;
    Button btnLogin_logar;
    Button btnLogin_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        edtLogin = findViewById(R.id.edt_LOGIN_usuario);
        edtSenha = findViewById(R.id.edt_LOGIN_senha);

        btnLogin_logar = findViewById(R.id.btn_LOGIN_entrar);
        btnLogin_logar.setOnClickListener(this);


        btnLogin_voltar = findViewById(R.id.btn_LOGIN_voltar);
        btnLogin_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String inputLogin = edtLogin.getText().toString();
        String inputSenha = edtSenha.getText().toString();


        if(v==btnLogin_logar){
            //A SER IMPLEMENTANDO

            if(inputLogin.isEmpty() || inputSenha.isEmpty()){

                Toast.makeText(this, "ATENÇÃO TODOS OS CAMPOS DEVEM SER PREENCHIDOS!!!", Toast.LENGTH_SHORT).show();

            }
        }

        else if(v==btnLogin_voltar){
            Intent telaVOltar = new Intent(this, MainActivity.class);
            startActivity(telaVOltar);
        }

    }
}