    package com.example.projeto_integrador_iv.dao;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;

    import com.example.projeto_integrador_iv.models.Cliente;

    import java.util.ArrayList;
    import java.util.List;

    public class ClienteDAO implements Dao<Cliente> {


        private final String TABELA = "cliente";

        private final String[] CAMPOS = {"cpf_cliente, nome, telefone, email, uf"};


        private SQLiteDatabase banco;
        private Conexao conexao;

        public ClienteDAO(Context context){

            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }

        //DAO REFERENTE AO CLIENTE

        //preencher do cliente
        private ContentValues preencherValoresCliente(Cliente cliente){

            ContentValues values = new ContentValues();

            values.put("cpf_cliente", cliente.getCpfCliente());
            values.put("nome", cliente.getNome());
            values.put("telefone", cliente.getTelefone());
            values.put("email", cliente.getEmail());
            values.put("uf", cliente.getUf());

            return values;
        }

        //inserir cliente no banco
        @Override
        public long insert(Cliente cliente){
            ContentValues values = preencherValoresCliente(cliente);
            long clienteCad = banco.insert(TABELA, null, values);
            return clienteCad;
        }

        @Override
        public long update(Cliente cliente) {
            ContentValues values = preencherValoresCliente(cliente);
            long clienteUpdate =  banco.update(TABELA, values, "cpf_cliente = ?", new String[]{String.valueOf(cliente.getCpfCliente())});
            return clienteUpdate;
        }

        @Override
        public List<Cliente> list() {
            Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

            List<Cliente> lista = new ArrayList<>();
            while(c.moveToNext()){
                Cliente cliente = new Cliente();
                cliente.setCpfCliente(c.getString(0));
                cliente.setNome(c.getString(1));
                cliente.setTelefone(c.getString(2));
                cliente.setEmail(c.getString(3));
                cliente.setUf(c.getString(4));
                lista.add(cliente);

            }
            return lista;
        }

        @Override
        public long remove(Cliente cliente) {
            long clienteRemoved = banco.delete(TABELA,"cpf_cliente = ?", new String[]{cliente.getCpfCliente()});
            return clienteRemoved;
        }

        @Override
        public Cliente get(String cpf) {
            Cursor c = banco.query(TABELA, CAMPOS,
                    "id = ?", new String[] {String.valueOf(cpf)}, null, null, null);
            if (c.moveToNext()) {
                Cliente cliente = new Cliente();
                cliente.setCpfCliente(c.getString(0));
                cliente.setNome(c.getString(1));
                cliente.setTelefone(c.getString(2));
                cliente.setEmail(c.getString(3));
                cliente.setUf(c.getString(4));
                return cliente;
            }
            else {
                return null;
            }
        }

    }

