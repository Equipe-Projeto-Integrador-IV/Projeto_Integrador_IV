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

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.dao.AgendamentoDAO;
import com.example.projeto_integrador_iv.dao.FuncionarioDAO;
import com.example.projeto_integrador_iv.dao.OrdemServicoDAO;
import com.example.projeto_integrador_iv.dao.ServicoDAO;
import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.models.OrdemServico;
import com.example.projeto_integrador_iv.models.Servico;
import com.example.projeto_integrador_iv.services.ConexaoService;
import com.example.projeto_integrador_iv.services.OrdemServicoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class atv_cadastro_ordem_servico extends AppCompatActivity implements View.OnClickListener {

    private Retrofit retrofit;
    OrdemServicoService oService;
    Context context;

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtOrdServico;
    EditText edtDataInicio;
    EditText edtDataFim;
    EditText edtHoraInicio;
    EditText edtHoraFim;
    EditText edtValor;

    Spinner spinStatus;
    Spinner spinAgendamento;
    Spinner spinServico;
    Spinner spinFuncionarioOS;
    Spinner spinFuncionarioSV;

    String acao;
    OrdemServico ordemServico;
    OrdemServicoDAO dao;

    AgendamentoDAO agendamentoDAO;
    List<Agendamento> listaAgendamento;

    ServicoDAO servicoDAO;
    List<Servico> listaServico;

    FuncionarioDAO funcionarioDAO;
    List<Funcionario> listaFuncionarioOS;
    List<Funcionario> listaFuncionarioSV;

    BaseAdapter baseAdapter;

    private void criarComponentes() {
        edtOrdServico = findViewById(R.id.edtOrdServico);
        edtDataInicio = findViewById(R.id.edtDataInicio);
        edtDataFim = findViewById(R.id.edtDataFim);
        edtHoraInicio = findViewById(R.id.edtHoraInicio);
        edtHoraFim = findViewById(R.id.edtHoraFim);
        edtValor = findViewById(R.id.edtValor);

        spinStatus = findViewById(R.id.spinStatus);
        spinAgendamento = findViewById(R.id.spinAgendamento);
        spinServico = findViewById(R.id.spinServico);
        spinFuncionarioOS = findViewById(R.id.spinFuncionarioOS);
        spinFuncionarioSV = findViewById(R.id.spinFuncionarioSV);

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

        agendamentoDAO = new AgendamentoDAO(this);
        listaAgendamento = agendamentoDAO.list();
        baseAdapter = new ArrayAdapter<Agendamento>(this, android.R.layout.simple_list_item_1, listaAgendamento);
        spinAgendamento.setAdapter(baseAdapter);

        servicoDAO = new ServicoDAO(this);
        listaServico = servicoDAO.list();
        baseAdapter = new ArrayAdapter<Servico>(this, android.R.layout.simple_list_item_1, listaServico);
        spinServico.setAdapter(baseAdapter);

        funcionarioDAO = new FuncionarioDAO(this);
        listaFuncionarioOS = funcionarioDAO.list();
        baseAdapter = new ArrayAdapter<Funcionario>(this, android.R.layout.simple_list_item_1, listaFuncionarioOS);
        spinFuncionarioOS.setAdapter(baseAdapter);

        listaFuncionarioSV = funcionarioDAO.list();
        baseAdapter = new ArrayAdapter<Funcionario>(this, android.R.layout.simple_list_item_1, listaFuncionarioSV);
        spinFuncionarioSV.setAdapter(baseAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_cadastro_ordem_servico);


        //RETROFIT
        ConexaoService conexaoService = new ConexaoService();
        retrofit = new Retrofit.Builder()
                .baseUrl(conexaoService.getUrlConexao())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        oService = retrofit.create(OrdemServicoService.class);
        context = this;
        //FIM RETROFIT

        acao = getIntent().getExtras().getString("acao");
        dao = new OrdemServicoDAO(this);
        criarComponentes();

        if(getIntent().getExtras().getSerializable("obj") != null) {
            ordemServico = (OrdemServico) getIntent().getExtras().getSerializable("obj");

            edtOrdServico.setText(ordemServico.getId_os().toString());

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            edtDataInicio.setText(df.format(new Date()));
            edtDataFim.setText(df.format(new Date()));

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            edtHoraInicio.setText(sdf.format(new Date()));
            edtHoraFim.setText((sdf.format(new Date())));

            edtValor.setText(String.valueOf(ordemServico.getValor()));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnVoltar) {
            finish();
        } else if (v == btnExcluir) {
            long id = dao.remove(ordemServico);
            Toast.makeText(this, "Ordem de Serviço " + ordemServico.getId_os() + " foi excluído com sucesso!",
                    Toast.LENGTH_LONG).show();
            finish();
        } else if (v == btnGravar) {
            try {
                String strDateInicio = edtDataInicio.getText().toString();
                String strDateFim = edtDataInicio.getText().toString();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                Date dateInicio = null;
                dateInicio = df.parse((strDateInicio));

                Date dateFim = null;
                dateFim = df.parse(strDateFim);

                ordemServico.setData_inicio(dateInicio);
                ordemServico.setData_fim(dateFim);

                String strHoraInicio = edtHoraInicio.getText().toString();
                String strHoraFim = edtHoraFim.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");

                Date horaInicio = new Date();
                horaInicio = sdf.parse(strHoraInicio);

                Date horaFim = new Date();
                horaFim = sdf.parse(strHoraFim);

                ordemServico.setHora_inicio(horaInicio);
                ordemServico.setHora_fim(horaFim);

                ordemServico.setStatus(spinStatus.getSelectedItem().toString());
                ordemServico.setValor(Float.valueOf(edtValor.getText().toString()));

                Agendamento agendamento = (Agendamento) spinAgendamento.getSelectedItem();
                ordemServico.setAgendamento(agendamento);

                Servico servico = (Servico) spinServico.getSelectedItem();
                ordemServico.setServico(servico);

                Funcionario funcOS = (Funcionario) spinFuncionarioOS.getSelectedItem();
                ordemServico.setRespOS(funcOS);

                Funcionario funcSV = (Funcionario) spinFuncionarioSV.getSelectedItem();
                ordemServico.setExecServico(funcSV);

                if (acao.equals("Inserir")) {
                    long id = dao.insert(ordemServico);
                    ordemServico.setId_os(id);
                    Call<OrdemServico> call = oService.postOrdemServico(ordemServico);
                    call.enqueue(new Callback<OrdemServico>() {
                        @Override
                        public void onResponse(Call<OrdemServico> call, Response<OrdemServico> response) {
                            if(response.isSuccessful()){
                                OrdemServico ordemservicoSalvo = response.body();
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdemServico> call, Throwable t) {

                        }
                    });

                    Toast.makeText(this, "Ordem de Serviço foi inserido com o id = " + ordemServico.getId_os(),
                            Toast.LENGTH_LONG).show();
                } else {
                    long id = dao.update(ordemServico);
                    Call<OrdemServico> call = oService.postOrdemServico(ordemServico);
                    Toast.makeText(this, "Ordem de Serviço " + ordemServico.getId_os() + " foi alterado com sucesso!",
                            Toast.LENGTH_LONG).show();

                    call.enqueue(new Callback<OrdemServico>() {
                        @Override
                        public void onResponse(Call<OrdemServico> call, Response<OrdemServico> response) {
                            if(response.isSuccessful()){
                                OrdemServico ordemservicoSalvo = response.body();
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdemServico> call, Throwable t) {

                        }
                    });
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
            finish();
        }

    }
}