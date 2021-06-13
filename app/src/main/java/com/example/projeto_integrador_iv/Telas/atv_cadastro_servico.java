package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.Float;
import java.math.BigDecimal;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Servico;
import com.example.projeto_integrador_iv.services.ConexaoService;
import com.example.projeto_integrador_iv.services.ServicoService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class atv_cadastro_servico extends AppCompatActivity implements View.OnClickListener {


    private Retrofit retrofit;
    ServicoService Sservice;
    Context context;

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtIdServico;
    EditText edtNomeServico;
    EditText edtPrecoCusto;
    EditText edtPrecoVenda;
    EditText edtDescricao;

    String acao;
    Servico s;
    ServicoDAO dao;

    private void criarComponentes() {
        btnGravar = findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(this);
        btnGravar.setText(acao);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(this);

        if (acao.equals("Inserir"))
            btnExcluir.setVisibility(View.INVISIBLE);
        else
            btnExcluir.setVisibility(View.VISIBLE);

        edtIdServico = findViewById(R.id.edtIdServico);
        edtNomeServico = findViewById(R.id.edtNomeServico);
        edtPrecoCusto = findViewById(R.id.edtPrecoCusto);
        edtPrecoVenda = findViewById(R.id.edtPrecoVenda);
        edtDescricao = findViewById(R.id.edtDescricao);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cadastro_servico);


        //RETROFIT
        ConexaoService conexaoService = new ConexaoService();
        retrofit = new Retrofit.Builder()
                .baseUrl(conexaoService.getUrlConexao())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sservice = retrofit.create(ServicoService.class);
        context = this;
        //FIM RETROFIT


        acao = getIntent().getExtras().getString("acao");
        dao = new ServicoDAO(this);
        criarComponentes();

        if (getIntent().getExtras().getSerializable("obj") != null) {
            s = (Servico) getIntent().getExtras().getSerializable("obj");
            edtIdServico.setText(s.getIdServico().toString());
            edtNomeServico.setText(s.getNome());
            edtPrecoCusto.setText(String.valueOf(s.getPreco_custo()));
            edtPrecoVenda.setText(String.valueOf(s.getPreco_venda()));
            edtDescricao.setText(s.getDescricao());
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnVoltar) {
            finish();
        } else if (v == btnExcluir) {
            long id = dao.remove(s);
            Toast.makeText(this, "Serviço " + s.getNome() + " foi excluído com sucesso!",
                    Toast.LENGTH_LONG).show();
            finish();
        } else if (v == btnGravar) {

            s.setNome(edtNomeServico.getText().toString());
            s.setPreco_custo(Float.valueOf(edtPrecoCusto.getText().toString()));
            s.setPreco_venda(Float.valueOf(edtPrecoVenda.getText().toString()));
            s.setDescricao(edtDescricao.getText().toString());

            if (acao.equals("Inserir")) {
                long id = dao.insert(s);
                s.setIdServico(id);
                Call<Servico> call = Sservice.postServico(s);

                call.enqueue(new Callback<Servico>() {
                    @Override
                    public void onResponse(Call<Servico> call, Response<Servico> response) {
                        if(response.isSuccessful()){
                            Servico servicoSalvo = response.body();
                        }
                    }

                    @Override
                    public void onFailure(Call<Servico> call, Throwable t) {

                    }
                });


                Toast.makeText(this, "Serviço " + s.getNome() + " foi inserido com o id = " + id,
                        Toast.LENGTH_LONG).show();
            } else {
                long id = dao.update(s);
                Toast.makeText(this, "Serviço " + s.getNome() + " foi alterado com sucesso!",
                        Toast.LENGTH_LONG).show();
            }
            finish();
        }
    }
}