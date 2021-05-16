package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeletarUsuario extends AppCompatActivity implements View.OnClickListener {

    Button btnDELETAR_excluir;
    Button btnDELETAR_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_usuario);


        btnDELETAR_excluir = findViewById(R.id.btnDELETAR_excluir);
        btnDELETAR_excluir.setOnClickListener(this);

        btnDELETAR_voltar = findViewById(R.id.btnDELETAR_voltar);
        btnDELETAR_voltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==btnDELETAR_voltar){
            Intent telaDELETAR_return  = new Intent(this, TelaPainelControle.class);
            startActivity(telaDELETAR_return);
        }
        else if (v==btnDELETAR_excluir){

        }

    }
}