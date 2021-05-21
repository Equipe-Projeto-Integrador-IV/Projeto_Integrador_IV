    package com.example.projeto_integrador_iv.dao;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;

    import com.example.projeto_integrador_iv.models.Servico;

    import java.util.ArrayList;
    import java.util.List;

    public class ServicoDAO implements Dao<Servico> {
        private final String TABELA = "servico";
        private final String[] CAMPOS = {"id_servico, nome, descricao, precoCusto, precoVenda"};

        private SQLiteDatabase banco;
        private Conexao conexao;

        private ServicoDAO(Context context) {
            conexao = new Conexao(context);
            banco = conexao.getWritableDatabase();
        }

        private ContentValues preencherValoresServicos(Servico servico){
            ContentValues values = new ContentValues();

            values.put("id_servico",servico.getIdServico());
            values.put("nome",servico.getNome());
            values.put("descricao", servico.getDescricao());
            values.put("precoCusto",servico.getPrecoCusto());
            values.put("precoVenda",servico.getPrecoVenda());

            return values;
        }

        @Override
        public long insert(Servico servico) {
            ContentValues values = preencherValoresServicos(servico);
            long servicoCad = banco.insert(TABELA, null, values);
            return servicoCad;
        }

        @Override
        public long update(Servico servico) {
            ContentValues values = preencherValoresServicos(servico);
            long servicoUpdate =  banco.update(TABELA,
                    values,
                    "id_servico = ?",
                    new String[]{String.valueOf(servico.getIdServico())});
            return servicoUpdate;
        }

        @Override
        public List<Servico> list() {
            Cursor c = banco.query(TABELA, CAMPOS, null, null, null, null, null);

            List<Servico> lista = new ArrayList<>();
            while(c.moveToNext()){
                Servico servico = new Servico();
                servico.setIdServico(c.getLong(0));
                servico.setNome(c.getString(1));
                servico.setDescricao(c.getString(2));
                servico.setPrecoCusto(c.getFloat(3));
                servico.setPrecoVenda(c.getFloat(4));
                lista.add(servico);

            }
            return lista;
        }

        @Override
        public long remove(Servico servico) {
            long servicoRemoved = banco.delete(TABELA,
                    "id_servico = ?",
                    new String[]{String.valueOf(servico.getIdServico())});
            return servicoRemoved;
        }

        public Servico get(long id) {
            Cursor c = banco.query(TABELA, CAMPOS,
                    "id_servico = ?", new String[] {String.valueOf(id)}, null, null, null);
            if (c.moveToNext()) {
                Servico servico = new Servico();
                servico.setIdServico(c.getLong(0));
                servico.setNome(c.getString(1));
                servico.setDescricao(c.getString(2));
                servico.setPrecoVenda(c.getFloat(3));
                servico.setPrecoCusto(c.getFloat(4));
                return servico;
            }
            else {
                return null;
            }
        }
    }
