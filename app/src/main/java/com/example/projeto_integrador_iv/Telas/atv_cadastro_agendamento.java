package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

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
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class atv_cadastro_agendamento extends AppCompatActivity implements View.OnClickListener {

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtIdAgendamento;
    EditText edtData;
    EditText edtHora;
    EditText edtStatus;
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
        edtStatus = findViewById(R.id.edtStatus);
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

            edtStatus.setText(agendamento.getStatus());

//            int func = retornarIndiceFuncionario(agendamento.getRespAgendamento().getCpfFuncionario());
//            spinFuncionario.setSelection(func);

//            int servico = retornarIndiceServico(agendamento.getServico().getIdServico());
//            spinServico.setSelection(servico);


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
            String strDate1 = edtHora.getText().toString();
            SimpleDateFormat dfs = new SimpleDateFormat("hh:mm:ss a");
            Date hora =null;
            try{

                hora =  dfs.parse(strDate1);
            }catch (ParseException e){
                e.printStackTrace();
            }
            agendamento.setDate(date);
            agendamento.setHora(hora);

//                agendamento.setDate( edtData.getText().toString());
//                agendamento.setHora((Date) edtHora.getText());
                agendamento.setStatus(edtStatus.getText().toString());

                Cliente cliente = (Cliente) spinCliente.getSelectedItem();
                agendamento.setCliente(cliente);

                Funcionario func = (Funcionario) spinFuncionario.getSelectedItem();
                agendamento.setRespAgendamento(func);

                Servico servico = (Servico) spinServico.getSelectedItem();
                agendamento.setServico(servico);

                agendamento.setObs(edtObs.getText().toString());

                if (acao.equals("Inserir")) {
                    long id = dao.insert(agendamento);
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