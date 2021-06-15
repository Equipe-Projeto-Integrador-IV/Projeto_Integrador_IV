package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Cliente;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCliente {

    private final String CPF_ESPERADO = "99999999999";
    private final String NOME_ESPERADO = "teste-nome";
    private final String TELEFONE_ESPERADO = "62998989898";
    private final String EMAIL_ESPERADO = "teste@email.com.br";
    private final String UF_ESPERADO = "GO";

    private static Cliente cliente;

    @BeforeAll
    public static void setUp(){
        cliente = new Cliente("99999999999","teste-nome","62998989898"
                ,"teste@email.com.br","GO");
    }

    @Test
    public void testeConstrutor(){
        assertEquals(CPF_ESPERADO,cliente.getCpfCliente());
        assertEquals(NOME_ESPERADO,cliente.getNome());
        assertEquals(TELEFONE_ESPERADO,cliente.getTelefone());
        assertEquals(EMAIL_ESPERADO,cliente.getEmail());
        assertEquals(UF_ESPERADO,cliente.getUf());
    }

    @Test
    public void testeToString(){
        String stringEsperado = " CPF: " + cliente.getCpfCliente() + "\n" + " Nome: " +
                cliente.getNome() + "\n " +
                "Fone: " + cliente.getTelefone();

        assertEquals(stringEsperado, cliente.toString());
    }

    @AfterAll
    private static void tearDown(){
        System.out.printf("#### TESTE FINALIZADO ####");
    }

}
