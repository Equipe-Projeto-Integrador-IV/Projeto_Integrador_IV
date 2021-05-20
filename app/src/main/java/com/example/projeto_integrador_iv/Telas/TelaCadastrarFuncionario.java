package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeto_integrador_iv.MainActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.models.Funcionario;

public class TelaCadastrarFuncionario extends AppCompatActivity implements View.OnClickListener {


    Button btnVoltar;
    Button btnCadastrarFunc;

    EditText edtCPF_FUNCIONARIO_Cad;
    EditText edtSENHA_FUNCIONARIO_Cad;

    ClienteDAO Cdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_funcionario);

        btnVoltar = findViewById(R.id.btn_VoltarCad);
        btnVoltar.setOnClickListener(this);
        btnCadastrarFunc = findViewById(R.id.btn_CadFunc);
        btnCadastrarFunc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltar){
            Intent voltar = new Intent(this, MainActivity.class);
            startActivity(voltar);
        }
        else if(v==btnCadastrarFunc){
            //A SER IMPLEMENTADO AINDA

            Funcionario funcionario = new Funcionario();

        }

    }
}