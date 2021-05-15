package com.example.projeto_integrador_iv.Telas.PainelControle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class EditarUsuarioInput extends AppCompatActivity implements View.OnClickListener{

    Button btnEditarUsuInput;
    Button btnVoltarInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario_input);

        btnEditarUsuInput = findViewById(R.id.btnProcurarCPFCliente);
        btnEditarUsuInput.setOnClickListener(this);

        btnVoltarInput = findViewById(R.id.btnVoltarInput);
        btnVoltarInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnEditarUsuInput){
            //ESSE BOTAO ELE PROCURA NO BANCO EXTERNO O USUARIO E JOGA OS ATRIBUTOS EM UM EDITTEXT DE OUTRA CLASSE E AO MESMO TEMPO CHAMA A OUTRA TELA
            // NECESSARIO IMPLEMENTAR AINDA

            Intent telaEdicao = new Intent(this, EditarUsuarioOutput.class);
            startActivity(telaEdicao);
        }
        else if (v==btnVoltarInput){
            Intent telaPainelRetorna = new Intent(this, TelaPainelControle.class);
            startActivity(telaPainelRetorna);
        }

    }
}