package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Servico;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServicoService {

    @Headers("Accept: application/json")
    @POST("/api/servico")
    Call<Servico> postServico(@Body Servico cliente);

    @Headers("Accept: application/json")
    @GET("/api/servico")
    Call<List<Servico>> getServico();


}
