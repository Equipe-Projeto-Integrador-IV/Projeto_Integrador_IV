package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.models.Servico;

import org.junit.jupiter.api.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestAgendamento {
    private final Long ID_AGENDAMENTO_ESPERADO = Long.valueOf(99);
    private final Date DATA_ESPERADA = new Date(1999,12,31);
    private final Date HORA_ESPERADA = new Time(12);
    private final String STATUS_ESPERADO = "teste_status";
    private final String OBSERVACAO_ESPERADA = "teste_observacao";
    private final Cliente CLIENTE_ESPERADO;
    private final Funcionario FUNCIONARIO_ESPERADO;
    private final Servico SERVICO_ESPERADO;

    private Agendamento agendamento;


    {
        CLIENTE_ESPERADO = new Cliente("99999999999", "teste_nome_cliente",
                "62999998888", "teste_cliente@email.com.br", "GO");
    }

    {
        FUNCIONARIO_ESPERADO = new Funcionario("99999999999","nome_funcionario",
                "password","teste@email.com.br",
                "62996696969","0,2");
    }

    {
        SERVICO_ESPERADO = new Servico((long) 99,"nome_servico","teste_descricao",
                99f,100f);
    }

    {
        agendamento = new Agendamento(ID_AGENDAMENTO_ESPERADO, DATA_ESPERADA,HORA_ESPERADA,
                STATUS_ESPERADO,OBSERVACAO_ESPERADA, CLIENTE_ESPERADO,FUNCIONARIO_ESPERADO,
                SERVICO_ESPERADO);
    }


    @Test
    public void testeConstrutor(){

        assertEquals(ID_AGENDAMENTO_ESPERADO, agendamento.getId());
        assertEquals(DATA_ESPERADA, agendamento.getData());
        assertEquals(HORA_ESPERADA, agendamento.getHora());
        assertEquals(STATUS_ESPERADO, agendamento.getStatus());
        assertEquals(OBSERVACAO_ESPERADA, agendamento.getObs());
        assertEquals(CLIENTE_ESPERADO, agendamento.getCliente());
        assertEquals(FUNCIONARIO_ESPERADO, agendamento.getRespAgendamento());
        assertEquals(SERVICO_ESPERADO, agendamento.getServico());
    }

    @Test
    public void testeToString(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(this.DATA_ESPERADA);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        String hora = sdf.format(this.HORA_ESPERADA);

        String resultado = " Agendamento: " + "\n" +
                " Id: " + ID_AGENDAMENTO_ESPERADO + "\n" +
                " Date: " + data + "\n" +
                " Hora: " + hora + "\n" +
                " Status: " + STATUS_ESPERADO + "\n" +
                "------------Dados Cliente----------------" + "\n" +
                " Cliente: " + CLIENTE_ESPERADO + "\n" +
                "------------Dados Funcionário------------" + "\n" +
                " Responsável-Agendamento: " + "\n" +
                FUNCIONARIO_ESPERADO + "\n" +
                "------------Dados Serviços---------------" + "\n" +
                SERVICO_ESPERADO + "\n" +
                "\n" +
                " Obs: " + OBSERVACAO_ESPERADA ;

        assertEquals(resultado, agendamento.toString());
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("#### TESTE FINALIZADO ####");
    }

}
