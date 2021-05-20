package com.example.projeto_integrador_iv.dao;

import java.util.List;

public interface Dao<S> {

    public long insert(S s);

    public long update(S s);

    public List<S> list();

    public long remove(S t);

//    public long remove(String cpf);

    public S get(String cpf);

}
