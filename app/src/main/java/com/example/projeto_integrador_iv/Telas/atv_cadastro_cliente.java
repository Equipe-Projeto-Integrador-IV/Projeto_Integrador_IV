package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.models.Cliente;

public class atv_cadastro_cliente extends AppCompatActivity implements View.OnClickListener {
    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtCpf;
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtUf;

    String acao;
    Cliente c;
    ClienteDAO dao;

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

        edtCpf = findViewById(R.id.edtCpf);
        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEmail = findViewById(R.id.edtEmail);
        edtUf = findViewById(R.id.edtUf);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cadastro_cliente);

        acao = getIntent().getExtras().getString("acao");
        dao =  new ClienteDAO(this);
        criarComponentes();

        if (getIntent().getExtras().getSerializable("obj") != null) {
            c = (Cliente) getIntent().getExtras().getSerializable("obj");
            edtCpf.setText(c.getCpfCliente());
            edtNome.setText(c.getNome());
            edtTelefone.setText(c.getTelefone());
            edtEmail.setText(c.getEmail());
            edtUf.setText(c.getUf());
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnVoltar) {
            finish();
        } else if (v == btnExcluir) {
            long cpf = dao.remove(c);
            Toast.makeText(this, "Cliente " + c.getNome() + " foi excluído com sucesso!",
                    Toast.LENGTH_SHORT).show();
            finish();
        } else if (v == btnGravar) {
            c.setCpfCliente(edtCpf.getText().toString());
            c.setNome(edtNome.getText().toString());
            c.setTelefone(edtTelefone.getText().toString());
            c.setEmail(edtEmail.getText().toString());
            c.setUf(edtUf.getText().toString());

            if (acao.equals("Inserir")) {
                long cpf = dao.insert(c);
                Toast.makeText(this, "Cliente " + c.getNome() + " foi cadastrado com sucesso!",
                        Toast.LENGTH_LONG).show();
            } else {
                long cpf = dao.update(c);
                Toast.makeText(this, "Cliente " + c.getNome() + " foi alterado com sucesso!",

                        Toast.LENGTH_LONG).show();
            }

            finish();
        }
    }
}