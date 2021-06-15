package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.FuncionarioDAO;
import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.services.ConexaoService;
import com.example.projeto_integrador_iv.services.FuncionarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaCadastrarFuncionario extends AppCompatActivity implements View.OnClickListener {

    private Retrofit retrofit;
    FuncionarioService Fservice;
    Context context;

    EditText edit_text_cpf;
    EditText edit_text_name;
    EditText edit_text_credentials;
    EditText edit_text_telefone;
    EditText edit_text_comissao;
    EditText edit_text_password;

    Button btnVoltar;
    Button btnCadastrarFunc;

    String acao;
    Funcionario funcionario;
    FuncionarioDAO dao;

    private void criarComponentes() {

        edit_text_telefone = findViewById(R.id.edit_text_telefone);
        edit_text_cpf = findViewById(R.id.edit_text_cpf);
        edit_text_comissao = findViewById(R.id.edit_text_comissao);
        edit_text_name = findViewById(R.id.edit_text_name);
        edit_text_credentials = findViewById(R.id.edit_text_credentials);
        edit_text_password = findViewById(R.id.edit_text_password);

        btnVoltar = findViewById(R.id.btn_voltar);
        btnVoltar.setOnClickListener(this);

        btnCadastrarFunc = findViewById(R.id.btn_register);
        btnCadastrarFunc.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_funcionario);

        criarComponentes();

        //RETROFIT
        ConexaoService conexaoService = new ConexaoService();
        retrofit = new Retrofit.Builder()
                .baseUrl(conexaoService.getUrlConexao())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Fservice = retrofit.create(FuncionarioService.class);
        context = this;
//FIM RETROFIT


    }

    @Override
    public void onClick(View v) {

        if(v == btnVoltar){
            finish();
        }
        else if(v == btnCadastrarFunc){

            dao = new FuncionarioDAO(this);
            funcionario = new Funcionario();

            funcionario.setTelefone(edit_text_telefone.getText().toString());
            funcionario.setCpfFuncionario(edit_text_cpf.getText().toString());
            funcionario.setComissao(edit_text_comissao.getText().toString());
            funcionario.setNome(edit_text_name.getText().toString());
            funcionario.setEmail(edit_text_credentials.getText().toString());
            funcionario.setSenha(edit_text_password.getText().toString());

            dao.insert(funcionario);
            Call<Funcionario> call = Fservice.postFuncionario(funcionario);

            call.enqueue(new Callback<Funcionario>() {
                @Override
                public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {

                    if(response.isSuccessful()) {
                        Funcionario funcSalvo = response.body();
                    }
                }

                @Override
                public void onFailure(Call<Funcionario> call, Throwable t) {

                }
            });

            finish();
        }

    }
}