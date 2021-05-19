package com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;
import com.example.projeto_integrador_iv.dao.ConexaoDAO;
import com.example.projeto_integrador_iv.models.Cliente;

public class CadastrarUsuario extends AppCompatActivity implements View.OnClickListener {

    Button btnVoltarUsuario;
    Button btnCadastrarUsuCad;

    EditText edtCadastrarUsuCad_cpf;
    EditText edtCadastrarUsuCad_nome;
    EditText edtCadastrarUsuCad_telefone;
    EditText edtCadastrarUsuCad_email;
    EditText edtCadastrarUsuCad_uf;
    ConexaoDAO Cdao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);


        btnVoltarUsuario = findViewById(R.id.btnCADASTRO_USU_voltar);
        btnVoltarUsuario.setOnClickListener(this);
        btnCadastrarUsuCad = findViewById(R.id.btnCADASTRO_USU_cad);
        btnCadastrarUsuCad.setOnClickListener(this);

        //cpf
        edtCadastrarUsuCad_cpf = findViewById(R.id.edtCADASTRO_USU_cpf);
        //nome
        edtCadastrarUsuCad_nome = findViewById(R.id.edtCADASTRO_USU_nome);
        //telefone
        edtCadastrarUsuCad_telefone = findViewById(R.id.edtCADASTRO_USU_telefone);
        //email
        edtCadastrarUsuCad_email = findViewById(R.id.edtCADASTRO_USU_email);
        //uf
        edtCadastrarUsuCad_uf = findViewById(R.id.edtCADASTRO_USU_uf);

    }

    @Override
    public void onClick(View v) {

        if(v==btnVoltarUsuario){
            Intent telaVoltar = new Intent(this, TelaPainelControle.class);
            startActivity(telaVoltar);
        }
        else if (v==btnCadastrarUsuCad){

            Cdao = new ConexaoDAO(this);
            Cliente c = new Cliente();
            c.setCpfCliente(edtCadastrarUsuCad_cpf.getText().toString());
            c.setNome(edtCadastrarUsuCad_nome.getText().toString());
            c.setTelefone(edtCadastrarUsuCad_telefone.getText().toString());
            c.setEmail(edtCadastrarUsuCad_email.getText().toString());
            c.setUf(edtCadastrarUsuCad_uf.getText().toString());
            Cdao.inserir(c);
        }

    }
}