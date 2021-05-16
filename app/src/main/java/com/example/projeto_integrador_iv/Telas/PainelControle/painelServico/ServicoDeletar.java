package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;

public class ServicoDeletar extends AppCompatActivity implements View.OnClickListener{


    Button btnServioExcluir_deleted;
    Button btnServicoExcluir_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_deletar);

        btnServioExcluir_deleted = findViewById(R.id.btnServicoExcluir_deleted);
        btnServioExcluir_deleted.setOnClickListener(this);
        btnServicoExcluir_voltar = findViewById(R.id.btnServicoExcluir_deleted);
        btnServicoExcluir_voltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v==btnServioExcluir_deleted){

        }
        else if (v==btnServicoExcluir_voltar){
            Intent telaVoltar = new Intent(this, TelaPainelControle.class);
            startActivity(telaVoltar);
        }

    }
}