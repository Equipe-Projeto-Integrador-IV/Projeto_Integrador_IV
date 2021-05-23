package com.example.projeto_integrador_iv.Telas.PainelControle.painelServico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.TelaPainelControle;
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Servico;

public class ServicoCadastrar extends AppCompatActivity implements View.OnClickListener {


    ServicoDAO Sdao;

    Button btnServicoCadastrar_telaCadastro;
    Button btnServicoVoltar_telaCadastro;

    EditText edtNomeServicoCad;
    EditText edtDescricaoCad;
    EditText edtPrecoCustoServicoCad;
    EditText edtPrecoVendaServicoCad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico_cadastrar);

        //BOTAO QUE IRA CADASTRAR AS INFO NO BANCO
        btnServicoCadastrar_telaCadastro = findViewById(R.id.btnServicoCadastrarServicoCad);
        btnServicoCadastrar_telaCadastro.setOnClickListener(this);

        //BOTAO PARA RETORNAR AO PAINEL
        btnServicoVoltar_telaCadastro = findViewById(R.id.btnServicoVoltarServicoCad);
        btnServicoVoltar_telaCadastro.setOnClickListener(this);

        //ATRIBUINDO OS EDIT TEXT
        edtNomeServicoCad = findViewById(R.id.edtNomeServicoCad);
        edtDescricaoCad = findViewById(R.id.edtDescricaoCad);
        edtPrecoCustoServicoCad = findViewById(R.id.edtPrecoCustoServicoCad);
        edtPrecoVendaServicoCad = findViewById(R.id.edtPrecoVendaServicoCad);
    }

    @Override
    public void onClick(View v) {
        if(v==btnServicoCadastrar_telaCadastro){

            Sdao = new ServicoDAO(this);
            Servico s = new Servico();

            s.setNome(edtNomeServicoCad.getText().toString());
            s.setDescricao(edtDescricaoCad.getText().toString());
            String valuePrecoCusto = edtPrecoCustoServicoCad.getText().toString();
            Float valueFinalPrecoCusto = Float.parseFloat(valuePrecoCusto);
            s.setPreco_custo(valueFinalPrecoCusto);
            String valuePrecoVenda = edtPrecoVendaServicoCad.getText().toString();
            Float valueFinalPrecoVenda = Float.parseFloat(valuePrecoVenda);
            s.setPreco_venda(valueFinalPrecoVenda);
            Sdao.insert(s);

        }
        else if(v==btnServicoVoltar_telaCadastro){
            Intent telaRetornarPainel = new Intent(this, TelaPainelControle.class);
            startActivity(telaRetornarPainel);
        }

    }
}