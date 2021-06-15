package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Servico;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServico {

    private final Long ID_SERVICO_ESPERADO = Long.valueOf(99);
    private final String NOME_ESPERADO = "nome_servico";
    private final String DESCRICAO_ESPERADA = "teste_descricao";
    private final Float PRECO_CUSTO_ESPERADO = 99f;
    private final Float PRECO_VENDA_ESPERADA = 100f;

    private static Servico servico;

    @BeforeAll
    public static void setUp(){
        servico = new Servico((long) 99,"nome_servico","teste_descricao",
                99f,100f);
    }

    @Test
    public void testeConstrutor(){
        assertEquals(ID_SERVICO_ESPERADO, servico.getIdServico());
        assertEquals(NOME_ESPERADO, servico.getNome());
        assertEquals(DESCRICAO_ESPERADA, servico.getDescricao());
        assertEquals(PRECO_CUSTO_ESPERADO, servico.getPreco_custo());
        assertEquals(PRECO_VENDA_ESPERADA, servico.getPreco_venda());
    }

    @Test
    public void testeToString(){
        String stringEsperado = " Servico: " + servico.getNome() +  "\n" + " Id: " +
                servico.getIdServico();

        assertEquals(stringEsperado, servico.toString());
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("#### TESTE FINALIZADO ####");
    }
}
