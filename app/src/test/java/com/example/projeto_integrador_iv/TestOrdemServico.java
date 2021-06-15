package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;
import com.example.projeto_integrador_iv.models.OrdemServico;
import com.example.projeto_integrador_iv.models.Servico;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrdemServico {
    private final Long ID_OS_ESPERADO = Long.valueOf(99);
    private final Date DATA_INICIO_ESPERADA = new Date(2000,12,31);
    private final Date DATA_FIM_ESPERADA = new Date(2000,12,31);
    private final Date HORA_INICIO_ESPERADA = new Time(1);
    private final Date HORA_FIM_ESPERADA = new Time(2);
    private final String STATUS_ESPERADO = "teste_status";
    private final Float VALOR_ESPERADO = Float.valueOf(100);
    private final Agendamento AGENDAMENTO_ESPERADO;
    private final Servico SERVICO_ESPERADO;
    private final Funcionario FUNC_RESP_OS_ESPERADO;
    private final Funcionario FUNC_RESP_SERVICO_ESPERADO;

    private OrdemServico ordemServico;

    private Funcionario FUNCIONARIO_ESPERADO = new Funcionario("99999999999","nome_funcionario",
            "password","teste@email.com.br",
            "62996696969","0,2");

    {
        FUNC_RESP_OS_ESPERADO = FUNCIONARIO_ESPERADO;
    }

    {
        FUNC_RESP_SERVICO_ESPERADO = FUNCIONARIO_ESPERADO;
    }

    private Cliente CLIENTE_ESPERADO = new Cliente("99999999999", "teste_nome_cliente",
            "62999998888", "teste_cliente@email.com.br", "GO");

    {
        SERVICO_ESPERADO = new Servico((long) 99, "nome_servico", "teste_descricao",
                99f, 100f);
    }

    {
        AGENDAMENTO_ESPERADO = new Agendamento(Long.valueOf(99), new Date(2000,12,31),
                new Time(1), STATUS_ESPERADO,"teste_obs", CLIENTE_ESPERADO,FUNCIONARIO_ESPERADO,
                SERVICO_ESPERADO);
    }

    {
        ordemServico = new OrdemServico(ID_OS_ESPERADO,DATA_INICIO_ESPERADA,DATA_FIM_ESPERADA,
                HORA_INICIO_ESPERADA,HORA_FIM_ESPERADA,STATUS_ESPERADO,VALOR_ESPERADO,
                AGENDAMENTO_ESPERADO,SERVICO_ESPERADO,FUNC_RESP_OS_ESPERADO,FUNC_RESP_SERVICO_ESPERADO);
    }

    @Test
    public void testeConstrutor(){
        assertEquals(ID_OS_ESPERADO, ordemServico.getId_os());
        assertEquals(DATA_INICIO_ESPERADA, ordemServico.getData_inicio());
        assertEquals(DATA_FIM_ESPERADA, ordemServico.getData_fim());
        assertEquals(HORA_INICIO_ESPERADA,ordemServico.getHora_inicio());
        assertEquals(HORA_FIM_ESPERADA,ordemServico.getHora_fim());
        assertEquals(STATUS_ESPERADO, ordemServico.getStatus());
        assertEquals(VALOR_ESPERADO, ordemServico.getValor());
        assertEquals(AGENDAMENTO_ESPERADO, ordemServico.getAgendamento());
        assertEquals(SERVICO_ESPERADO, ordemServico.getServico());
        assertEquals(FUNC_RESP_OS_ESPERADO, ordemServico.getRespOS());
        assertEquals(FUNC_RESP_SERVICO_ESPERADO, ordemServico.getExecServico());
    }


    @AfterAll
    public static void tearDown(){
        System.out.println("#### TESTE FINALIZADO ####");
    }

}
