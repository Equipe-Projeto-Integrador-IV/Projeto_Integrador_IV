package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

public class ListarUsuarios extends AppCompatActivity implements View.OnClickListener{


    Button btnVoltar_TelaListarUsuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);


    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltar_TelaListarUsuarios){
            Intent telaRetornarListarUsuario = new Intent(this, TelaPainelControle.class);
            startActivity(telaRetornarListarUsuario);
        }

    }
}