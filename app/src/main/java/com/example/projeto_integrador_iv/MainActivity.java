package com.example.projeto_integrador_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projeto_integrador_iv.Telas.AtvPainel_controle;
import com.example.projeto_integrador_iv.Telas.TelaCadastrarFuncionario;
import com.example.projeto_integrador_iv.dao.FuncionarioDAO;
import com.example.projeto_integrador_iv.dao.FuncionarioLogin;
import com.example.projeto_integrador_iv.models.Funcionario;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtCredentials;
    EditText edtPassword;

    Button btnCadastrar;
    Button btnEntrar;

    private FuncionarioLogin funcionarioLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCredentials = findViewById(R.id.edtCredentials);
        edtPassword = findViewById(R.id.edtPassword);

        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        funcionarioLogin =  new FuncionarioLogin(this);

//        funcionarioLogado();
    }

    private void funcionarioLogado() {
        String cpf = funcionarioLogin.logadoCpf();
        if (cpf != null) {
            entrarPainelControle();
        }
    }

    private void entrarPainelControle() {
        Intent telaEntrar = new Intent(this, AtvPainel_controle.class);
        startActivity(telaEntrar);
    }

    private Funcionario searchFuncionario(String email, String senha) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(this);

        List<Funcionario> funcionarios = funcionarioDAO.list();

        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha));
            return funcionario;
        }

        return null;
    }

    @Override
    public void onClick(View v) {

        if(v==btnCadastrar) {
            Intent telaCadastrar = new Intent(this, TelaCadastrarFuncionario.class);
            startActivity(telaCadastrar);
       }
         else if (v == btnEntrar) {
            String email = edtCredentials.getText().toString();
            String senha = edtPassword.getText().toString();

            Funcionario funcionario = searchFuncionario(email, senha);

            if(funcionario != null) {
                if((email) == null && (senha) == null) {
                    Toast.makeText(this, "Preencha os campos", Toast.LENGTH_LONG).show();
                    return;
                }
                funcionarioLogin.RealizarLogin(funcionario);
                entrarPainelControle();
            } else {
                Toast.makeText(this, "Email ou senha inválido...", Toast.LENGTH_SHORT).show();
            }
      }

    }
}