package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.PainelControle.DeletarUsuario;
import com.example.projeto_integrador_iv.Telas.PainelControle.EditarUsuarioInput;
import com.example.projeto_integrador_iv.Telas.PainelControle.TelaCadastroUsuario;

public class TelaPainelControle extends AppCompatActivity implements View.OnClickListener{

    Button btn_PainCadUsu;
    Button btn_PainVoltar;
    Button btn_PainEditUsu;
    Button btn_PainExcluirUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_painel_controle);


        btn_PainCadUsu = findViewById(R.id.btnPainelCliente);
        btn_PainCadUsu.setOnClickListener(this);
        btn_PainVoltar = findViewById(R.id.btnPainelVoltar);
        btn_PainVoltar.setOnClickListener(this);
        btn_PainEditUsu = findViewById(R.id.btnPainelEditarCliente);
        btn_PainEditUsu.setOnClickListener(this);
        btn_PainExcluirUsu = findViewById(R.id.btnPainelExcluirCliente);
        btn_PainExcluirUsu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btn_PainVoltar){
            Intent tela = new Intent(this, TelaLogin.class);
            startActivity(tela);
        }
        else if(v==btn_PainCadUsu){
            Intent tela2 = new Intent(this, TelaCadastroUsuario.class);
            startActivity(tela2);
        }
        else if(v==btn_PainEditUsu){
            Intent tela3 = new Intent(this, EditarUsuarioInput.class);
            startActivity(tela3);
        }
        else if(v==btn_PainExcluirUsu){
            Intent tela4 = new Intent(this, DeletarUsuario.class);
            startActivity(tela4);
        }

    }
}