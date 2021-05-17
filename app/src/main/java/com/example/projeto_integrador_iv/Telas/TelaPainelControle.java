package com.example.projeto_integrador_iv.Telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projeto_integrador_iv.R;
import com.example.projeto_integrador_iv.Telas.PainelControle.DeletarOrdemServico;
import com.example.projeto_integrador_iv.Telas.PainelControle.OrdemServicoCadastrar;
import com.example.projeto_integrador_iv.Telas.PainelControle.OrdemServicoEditarInput;
import com.example.projeto_integrador_iv.Telas.PainelControle.OrdemServicoListar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento.AgendamentoCadastrar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento.AgendamentoDeletar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento.AgendamentoEditarInput;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelAgendamento.AgendamentoListar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelServico.ServicoCadastrar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelServico.ServicoDeletar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelServico.ServicoEditarInput;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelServico.ServicoListar;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario.DeletarUsuario;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario.EditarUsuarioInput;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario.CadastrarUsuario;
import com.example.projeto_integrador_iv.Telas.PainelControle.painelUsuario.ListarUsuarios;

public class TelaPainelControle extends AppCompatActivity implements View.OnClickListener{

    //CLIENTES
    Button btn_PainCadUsu;
    Button btn_PainVoltar;
    Button btn_PainEditUsu;
    Button btn_PainExcluirUsu;
    Button btn_PainelListarUsu;

    //SERVIÇO
    Button btn_PainCadServico;
    Button btn_PainListarServico;
    Button btn_PainEditServico;
    Button btn_PainExcluirServico;

    //AGENDAMENTO
    Button btn_PainCadAgendamento;
    Button btn_PainListarAgendamento;
    Button btn_PainEditarAgendamento;
    Button btn_PainExcluirAgendamento;

    //ORDEM DE SERVIÇO
    Button btn_PainCadOrdemServico;
    Button btn_PainListarOrdemServico;
    Button btn_PainOrdemServicoEditInput;
    Button btn_PainOrdemServicoDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_painel_controle);

        //CLIENTE
        btn_PainCadUsu = findViewById(R.id.btnPainelCliente);
        btn_PainCadUsu.setOnClickListener(this);
        btn_PainVoltar = findViewById(R.id.btnPainelVoltar);
        btn_PainVoltar.setOnClickListener(this);
        btn_PainEditUsu = findViewById(R.id.btnPainelEditarCliente);
        btn_PainEditUsu.setOnClickListener(this);
        btn_PainExcluirUsu = findViewById(R.id.btnPainelExcluirCliente);
        btn_PainExcluirUsu.setOnClickListener(this);
        btn_PainelListarUsu = findViewById(R.id.btnPainelListarCLiente);
        btn_PainelListarUsu.setOnClickListener(this);

        //SERVICO
        btn_PainCadServico = findViewById(R.id.btnPainelServicoCadastrar);
        btn_PainCadServico.setOnClickListener(this);
        btn_PainListarServico = findViewById(R.id.btnPainelServicoListar);
        btn_PainListarServico.setOnClickListener(this);
        btn_PainEditServico = findViewById(R.id.btnPainelServicoEditar);
        btn_PainEditServico.setOnClickListener(this);
        btn_PainExcluirServico = findViewById(R.id.btnPainelServicoExcluir);
        btn_PainExcluirServico.setOnClickListener(this);

        //AGENDAMENTO
        btn_PainCadAgendamento = findViewById(R.id.btnPainelAgendamento);
        btn_PainCadAgendamento.setOnClickListener(this);
        btn_PainListarAgendamento = findViewById(R.id.btnPainelListarAgendamentos);
        btn_PainListarAgendamento.setOnClickListener(this);
        btn_PainEditarAgendamento = findViewById(R.id.btnPainelEditarAgendamento);
        btn_PainEditarAgendamento.setOnClickListener(this);
        btn_PainExcluirAgendamento = findViewById(R.id.btnPainelExcluirAgendamento);
        btn_PainExcluirAgendamento.setOnClickListener(this);


        //ORDEM DE SERVIÇO
        btn_PainCadOrdemServico = findViewById(R.id.btnPainelOrdem);
        btn_PainCadOrdemServico.setOnClickListener(this);
        btn_PainListarOrdemServico = findViewById(R.id.btnPainelListarOrdensServicos);
        btn_PainListarOrdemServico.setOnClickListener(this);
        btn_PainOrdemServicoEditInput = findViewById(R.id.btnPainelEditarOrdem);
        btn_PainOrdemServicoEditInput.setOnClickListener(this);
        btn_PainOrdemServicoDeletar = findViewById(R.id.btnPainelExcluirOrdem);
        btn_PainOrdemServicoDeletar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        //açoes do usuario
        if(v==btn_PainVoltar){
            Intent tela = new Intent(this, TelaLogin.class);
            startActivity(tela);
        }
        else if(v==btn_PainCadUsu){
            Intent tela2 = new Intent(this, CadastrarUsuario.class);
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
        else if (v==btn_PainelListarUsu){
            Intent tela5 = new Intent(this, ListarUsuarios.class);
            startActivity(tela5);
        }
        //açoes do servico
        else if (v==btn_PainCadServico){
            Intent tela6 = new Intent(this, ServicoCadastrar.class);
            startActivity(tela6);
        }
        else if(v==btn_PainListarServico){
            Intent tela7 = new Intent(this, ServicoListar.class);
            startActivity(tela7);
        }
        else if (v==btn_PainEditServico){
            Intent tela8 = new Intent(this, ServicoEditarInput.class);
            startActivity(tela8);
        }
        else if (v==btn_PainExcluirServico){
            Intent tela9 = new Intent(this, ServicoDeletar.class);
            startActivity(tela9);
        }
        //açoes do agendamento
        else if (v==btn_PainCadAgendamento){
            Intent tela10 = new Intent(this, AgendamentoCadastrar.class);
            startActivity(tela10);
        }
        else if (v==btn_PainListarAgendamento){
            Intent tela11 = new Intent(this, AgendamentoListar.class);
            startActivity(tela11);
        }
        else if (v==btn_PainEditarAgendamento){
            Intent tela12 = new Intent(this, AgendamentoEditarInput.class);
            startActivity(tela12);
        }
        else if (v==btn_PainExcluirAgendamento){
            Intent tela13 = new Intent(this, AgendamentoDeletar.class);
            startActivity(tela13);
        }

        //açoes da ordem de serviço
        else if (v==btn_PainCadOrdemServico){
            Intent tela14 = new Intent(this, OrdemServicoCadastrar.class);
            startActivity(tela14);
        }
        else if (v==btn_PainListarOrdemServico){
            Intent tela15 = new Intent(this, OrdemServicoListar.class);
            startActivity(tela15);
        }
        else if (v==btn_PainOrdemServicoEditInput){
            Intent tela16 = new Intent(this, OrdemServicoEditarInput.class);
            startActivity(tela16);
        }
        else if (v==btn_PainOrdemServicoDeletar){
            Intent tela17 = new Intent(this, DeletarOrdemServico.class);
            startActivity(tela17);
        }

    }
}