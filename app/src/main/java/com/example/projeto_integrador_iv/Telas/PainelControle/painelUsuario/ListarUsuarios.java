package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;
import com.example.projeto_integrador_iv.dao.ConexaoDAO;
import com.example.projeto_integrador_iv.models.Cliente;

public class ListarUsuarios extends AppCompatActivity implements View.OnClickListener{


    ConexaoDAO Cdao;
    Button btnVoltar_TelaListarUsuarios;
    TextView listar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);


        listar = findViewById(R.id.textView);

        Cliente c= new Cliente();
        Cdao = new ConexaoDAO(this);

        

        //listar.setText(Cdao.listar().toString());




    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltar_TelaListarUsuarios){
            Intent telaRetornarListarUsuario = new Intent(this, TelaPainelControle.class);
            startActivity(telaRetornarListarUsuario);
        }

    }
}