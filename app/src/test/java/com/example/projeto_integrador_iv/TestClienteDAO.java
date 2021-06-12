package com.example.projeto_integrador_iv;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.room.Room;

import com.example.projeto_integrador_iv.dao.ClienteDAO;
import com.example.projeto_integrador_iv.dao.Conexao;
import com.example.projeto_integrador_iv.models.Cliente;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestClienteDAO {


//    @Test
//    public void testeInserir(){
//        Cliente cliente = new Cliente("03003003203", "nome teste","62999899565",
//                "teste@teste.com.br", "GO");
//        ClienteDAO clienteDAO = new ClienteDAO();
//        clienteDAO.insert(cliente);
//        Cliente clienteDb = clienteDAO.get(cliente.getCpfCliente());
//        assertNotNull(clienteDb);
//    }
}
