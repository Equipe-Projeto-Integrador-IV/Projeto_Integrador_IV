package com.example.projeto_integrador_iv.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String NAME = "banco.db";
    private static final int VERSION = 1;

    private static final String SQLCREATECLIENTE = "CREATE TABLE cliente (\n" +
            "    cpf_cliente VARCHAR PRIMARY KEY\n" +
            "                        NOT NULL,\n" +
            "    nome        VARCHAR NOT NULL,\n" +
            "    telefone    VARCHAR NOT NULL,\n" +
            "    email       VARCHAR NOT NULL,\n" +
            "    uf          VARCHAR NOT NULL\n" +
            ");";

    private static final String SQLCREATEFUNCIONARIO="CREATE TABLE funcionario (\n" +
            "    cpf_funcionario VARCHAR PRIMARY KEY\n" +
            "                            NOT NULL,\n" +
            "    nome           VARCHAR NOT NULL,\n" +
            "    email           VARCHAR NOT NULL,\n" +
            "    fone            VARCHAR NOT NULL,\n" +
            "    comissao        NUMERIC NOT NULL\n" +
            ");";

    private static final String SQLCREATESERVICO="CREATE TABLE servico (\n" +
            "    id_servico  INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                              NOT NULL,\n" +
            "    nome        VARCHAR (50)  NOT NULL,\n" +
            "    descricao   VARCHAR (120) NOT NULL,\n" +
            "    preco_custo NUMERIC       NOT NULL,\n" +
            "    preco_venda NUMERIC       NOT NULL\n" +
            ");";


    private static final String SQLCREATEAGENDAMENTO="CREATE TABLE agendamento (\n" +
            "    id                             INTEGER       PRIMARY KEY AUTOINCREMENT\n" +
            "                                                 NOT NULL,\n" +
            "    data                           DATE          NOT NULL,\n" +
            "    hora                           TIME          NOT NULL,\n" +
            "    status                         VARCHAR (50)  NOT NULL,\n" +
            "    observacao                     VARCHAR (100) NOT NULL,\n" +
            "    cpf_cliente_fk_agendamento     VARCHAR       REFERENCES cliente (cpf_cliente),\n" +
            "    cpf_funcionario_fk_agendamento VARCHAR       NOT NULL\n" +
            "                                                 REFERENCES funcionario (cpf_funcionario),\n" +
            "    id_servico_fk_agendamento      INTEGER       NOT NULL\n" +
            "                                                 REFERENCES servico (id_servico) \n" +
            ");";

    private static final String SQLCREATEORDEMSERVICO="CREATE TABLE ordem_servico (\n" +
            "    id_os                      INTEGER PRIMARY KEY AUTOINCREMENT\n" +
            "                                       NOT NULL,\n" +
            "    data_inicio                DATE    NOT NULL,\n" +
            "    data_fim                   DATE    NOT NULL,\n" +
            "    hora_inicio                TIME    NOT NULL,\n" +
            "    hora_fim                   TIME    NOT NULL,\n" +
            "    status                     VARCHAR NOT NULL,\n" +
            "    valor                      NUMERIC NOT NULL,\n" +
            "    id_agendamento_fk          INTEGER NOT NULL\n" +
            "                                       REFERENCES agendamento (id),\n" +
            "    id_servico_fk              INTEGER NOT NULL\n" +
            "                                       REFERENCES servico (id_servico),\n" +
            "    cpf_funcionario_fk_os      VARCHAR NOT NULL\n" +
            "                                       REFERENCES funcionario (cpf_funcionario),\n" +
            "    cpf_funcionario_fk_servico VARCHAR NOT NULL\n" +
            "                                       REFERENCES funcionario (cpf_funcionario));";

    //Construtor
    public Conexao(@Nullable Context context) { super(context, NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCREATECLIENTE);
        db.execSQL(SQLCREATEFUNCIONARIO);
        db.execSQL(SQLCREATESERVICO);
        db.execSQL(SQLCREATEAGENDAMENTO);
        db.execSQL(SQLCREATEORDEMSERVICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
