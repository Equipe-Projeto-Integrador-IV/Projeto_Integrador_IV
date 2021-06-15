package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Funcionario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FuncionarioService {


    @Headers("Accept: application/json")
    @POST("/api/funcionario")
    Call<Funcionario> postFuncionario(@Body Funcionario cliente);

    @Headers("Accept: application/json")
    @GET("/api/funcionario")
    Call<List<Funcionario>> getFuncionario();
}
