package com.example.projeto_integrador_iv;

import com.example.projeto_integrador_iv.models.Cliente;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCliente {
    public static final String CPF_ESPERADO = "99999999999";
    public static final String NOME_ESPERADO = "nome";
    public static final String TELEFONE_ESPERADO = "62999998888";
    public static final String EMAIL_ESPERADO = "teste@teste.com";
    public static final String UF_ESPERADO = "GO";

    private Cliente cliente;


    @Before
    public void setUp() throws Exception{
        cliente = new Cliente("99999999999", "nome", "62999998888",
                "teste@teste.com", "GO");
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("Teste finalizado.");
    }

    @Test
    public void testeAtributosCliente() throws Exception{
        Assert.assertEquals(CPF_ESPERADO, cliente.getCpfCliente());
        Assert.assertEquals(NOME_ESPERADO, cliente.getNome());
        Assert.assertEquals(TELEFONE_ESPERADO, cliente.getTelefone());
        Assert.assertEquals(EMAIL_ESPERADO, cliente.getEmail());
        Assert.assertEquals(UF_ESPERADO, cliente.getUf());
    }

    @Test
    public void testeSeUfDiferenteDeDoisCaracteres(){
        cliente.setUf("GOO");
        Assert.assertNotEquals("GOO", cliente.getUf());
    }

    @Test
    public void testeSeEmailEstaIncorreto() {
        cliente.setEmail("teste_sem_arroba");
        Assert.assertNotEquals("teste_sem_arroba", cliente.getEmail());
    }
}
