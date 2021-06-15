package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFuncionario {
    private final String CPF_ESPERADO = "99999999999";
    private final String NOME_ESPERADO = "nome_funcionario";
    private final String SENHA_ESPERADA = "password";
    private final String EMAIL_ESPERADO = "teste@email.com.br";
    private final String TELEFONE_ESPERADO = "62996696969";
    private final String COMISSAO_ESPERADA = "0,2";

    private static Funcionario funcionario;

    @BeforeAll
    public static void setUp(){
        funcionario = new Funcionario("99999999999","nome_funcionario",
                "password","teste@email.com.br",
                "62996696969","0,2");
    }

    @Test
    public void testeConstrutor(){
        assertEquals(CPF_ESPERADO,funcionario.getCpfFuncionario());
        assertEquals(NOME_ESPERADO,funcionario.getNome());
        assertEquals(SENHA_ESPERADA,funcionario.getSenha());
        assertEquals(TELEFONE_ESPERADO,funcionario.getTelefone());
        assertEquals(EMAIL_ESPERADO,funcionario.getEmail());
        assertEquals(COMISSAO_ESPERADA,funcionario.getComissao());
    }

    @Test
    public void testeToString(){
        String stringEsperado = " CPF: " + funcionario.getCpfFuncionario() + "\n" + " Nome:"
                + funcionario.getNome() + "\n" + " E-mail: " +
                funcionario.getEmail();

        assertEquals(stringEsperado, funcionario.toString());
    }

    @AfterAll
    private static void tearDown(){
        System.out.printf("#### TESTE FINALIZADO ####");
    }
}
