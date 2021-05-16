package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditarUsuarioOutput extends AppCompatActivity implements View.OnClickListener {

    Button btnVoltar_out;
    Button btnAlterar_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario_output);

        btnAlterar_out = findViewById(R.id.ButtonAlterarOut);
        btnAlterar_out.setOnClickListener(this);
        btnVoltar_out = findViewById(R.id.ButtonVoltarOut);
        btnVoltar_out.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btnVoltar_out){
            Intent telaVoltar = new Intent(this, EditarUsuarioInput.class);
            startActivity(telaVoltar);
        }
        else if(v==btnVoltar_out){

        }

    }
}