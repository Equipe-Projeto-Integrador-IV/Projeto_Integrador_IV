package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.String;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.AgendamentoDAO;
import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.dao.FuncionarioDAO;
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.models.Servico;
import com.example.projeto_integrador_iv.services.AgendamentoService;
import com.example.projeto_integrador_iv.services.ConexaoService;


import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class atv_cadastro_agendamento extends AppCompatActivity implements View.OnClickListener {


    private Retrofit retrofit;
    AgendamentoService aService;
    Context context;

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtIdAgendamento;
    EditText edtData;
    EditText edtHora;
    Spinner spinStatus;
    Spinner spinFuncionario;
    Spinner spinServico;
    Spinner spinCliente;
    EditText edtObs;

    String acao;
    Agendamento agendamento;
    AgendamentoDAO dao;

    ClienteDAO clienteDAO;
    List<Cliente> listaCliente;

    FuncionarioDAO funcionarioDAO;
    List<Funcionario> listaFuncionario;

    ServicoDAO servicoDAO;
    List<Servico> listaServico;

    BaseAdapter baseAdapter;

    private void criarComponentes() {

        edtIdAgendamento = findViewById(R.id.edtIdAgendamento);
        edtData = findViewById(R.id.edtData);
        edtHora = findViewById(R.id.edtHora);
        spinStatus = findViewById(R.id.spinStatus);
        spinCliente = findViewById(R.id.spinCliente);
        spinFuncionario = findViewById(R.id.spinFuncionario);
        spinServico = findViewById(R.id.spinServico);
        edtObs = findViewById(R.id.edtObs);

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

//        agendamento.setStatus(spinStatus.getSelectedItem().toString());

        clienteDAO = new ClienteDAO(this);
        listaCliente = clienteDAO.list();
        baseAdapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, listaCliente);
        spinCliente.setAdapter(baseAdapter);

        funcionarioDAO = new FuncionarioDAO(this);
        listaFuncionario = funcionarioDAO.list();
        baseAdapter = new ArrayAdapter<Funcionario>(this, android.R.layout.simple_list_item_1, listaFuncionario);
        spinFuncionario.setAdapter(baseAdapter);

        servicoDAO = new ServicoDAO(this);
        listaServico = servicoDAO.list();
        baseAdapter = new ArrayAdapter<Servico>(this, android.R.layout.simple_list_item_1, listaServico);
        spinServico.setAdapter(baseAdapter);
    }

    int retornarIndiceCliente(String cpf) {
        int indice = 0;
        for (Cliente obj: listaCliente) {
            if (obj.getCpfCliente() == cpf) {
                return indice;
            }
            indice++;
        }
        return 0;
    }

    int retornarIndiceFuncionario(String cpf) {
        int indice = 0;
        for (Funcionario obj: listaFuncionario) {
            if (obj.getCpfFuncionario() == cpf) {
                return indice;
            }
            indice++;
        }
        return 0;
    }

    int retornarIndiceServico(Long idServico) {
        int indice = 0;
        for (Servico obj: listaServico) {
            if (obj.getIdServico() == idServico) {
                return indice;
            }
            indice++;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cadastro_agendamento);


        //RETROFIT
        ConexaoService conexaoService = new ConexaoService();
        retrofit = new Retrofit.Builder()
                .baseUrl(conexaoService.getUrlConexao())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aService = retrofit.create(AgendamentoService.class);
        context = this;
        //FIM RETROFIT

        acao = getIntent().getExtras().getString("acao");
        dao = new AgendamentoDAO(this);
        criarComponentes();

        if(getIntent().getExtras().getSerializable("obj") != null) {
            agendamento = (Agendamento) getIntent().getExtras().getSerializable("obj");

            edtIdAgendamento.setText(agendamento.getId().toString());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            edtData.setText(sdf.format(new Date()));

            SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a");
            edtHora.setText(df.format(new Date()));


//               String strHour = edtHora.getText().toString();
//               SimpleDateFormat dfHour = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
//               Date hour = null;
//               hour = dfHour.parse(strHour);
//               agendamento.setDate(hour);

            edtObs.setText(agendamento.getObs());
//
//            int cliente = retornarIndiceCliente(agendamento.getCliente().getCpfCliente());
//            spinServico.setSelection(cliente);
//
//          int func = retornarIndiceFuncionario(agendamento.getRespAgendamento().getCpfFuncionario());
//          spinFuncionario.setSelection(func);
//
//           int servico = retornarIndiceServico(agendamento.getServico().getIdServico());
//           spinServico.setSelection(servico);




        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnVoltar) {
            finish();
        } else if (v == btnExcluir) {
            long id = dao.remove(agendamento);
            Toast.makeText(this, "Agendamento " + agendamento.getId() + " foi excluído com sucesso!",
                    Toast.LENGTH_LONG).show();
            finish();

        } else if (v == btnGravar) {

                String strDate = edtData.getText().toString();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
            try {
                date = df.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            agendamento.setData(date);

            String strHour = edtHora.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            Date hora = new Date();
            try {
                hora = sdf.parse(strHour);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            agendamento.setHora(hora);

                agendamento.setStatus(spinStatus.getSelectedItem().toString());

                Cliente cliente = (Cliente) spinCliente.getSelectedItem();
                 agendamento.setCliente(cliente);

                Funcionario func = (Funcionario) spinFuncionario.getSelectedItem();
                agendamento.setRespAgendamento(func);

                Servico servico = (Servico) spinServico.getSelectedItem();
                agendamento.setServico(servico);

                agendamento.setObs(edtObs.getText().toString());

                if (acao.equals("Inserir")) {

                    long id = dao.insert(agendamento);
                    agendamento.setId(id);

                    Call<Agendamento> call = aService.postAgendamento(agendamento);

                    call.enqueue(new Callback<Agendamento>() {
                        @Override
                        public void onResponse(Call<Agendamento> call, Response<Agendamento> response) {
                            if(response.isSuccessful()){
                                Agendamento agendamentoSalvo = response.body();
                            }
                        }

                        @Override
                        public void onFailure(Call<Agendamento> call, Throwable t) {

                        }
                    });


                    Toast.makeText(this, "Agendamento foi inserido com o id = " + agendamento.getId(),
                            Toast.LENGTH_LONG).show();
                } else {
                    long id = dao.update(agendamento);
                    Toast.makeText(this, "Agendamento " + agendamento.getId() + " foi alterado com sucesso!",
                            Toast.LENGTH_LONG).show();
                }
                finish();
            }
        }

}