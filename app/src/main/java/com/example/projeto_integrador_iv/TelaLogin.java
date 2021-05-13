package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class TelaLogin extends AppCompatActivity implements View.OnClickListener {


    private String login="admin@admin.com";
    private String senha="admin";
    boolean isValid=false;


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
        edtSenha.setTransformationMethod(new PasswordTransformationMethod());

        btnLogin_logar = findViewById(R.id.btn_LOGIN_entrar);
        btnLogin_logar.setOnClickListener(this);


        btnLogin_voltar = findViewById(R.id.btn_LOGIN_voltar);
        btnLogin_voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String inputLogin = edtLogin.getText().toString();
        String inputSenha = edtSenha.getText().toString();

        //TELA DO BUTTON LOGAR - O USUARIO DEVE TER O LOGIN E SENHA
        if(v==btnLogin_logar){

            //CASO O LOGIN OU SENHA OU AMBOS ESTEJAM EM BRANCO, SERA APRESENTADO UM TOAST DE QUE OS CAMPOS DEVEM SER PREENCHIDOS
            if(inputLogin.isEmpty() || inputSenha.isEmpty()){

                Toast.makeText(this, "ATENÇÃO TODOS OS CAMPOS DEVEM SER PREENCHIDOS!!!", Toast.LENGTH_SHORT).show();

            }
            /* AQUI E A VALIDAÇAO, FUTURAMENTE SERA MODIFICADO, ATUALMENTE E admin@admin.com E SENHA admin
             *
             */
            else{
                isValid = validacao(inputLogin, inputSenha);
                if(isValid){
                    Intent telaCadUsu = new Intent(this, TelaCadastroUsuario.class);
                    startActivity(telaCadUsu);
                }
                else{
                    Toast.makeText(this, "LOGIN OU SENHA INCORRETO!!!", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if(v==btnLogin_voltar){
            Intent telaVOltar = new Intent(this, MainActivity.class);
            startActivity(telaVOltar);
        }

    }
    private boolean validacao(String loginF, String senhaF){


        if(loginF.equals(login) && senhaF.equals(senha)){
            return true;
        }

        return false;
    }
}