package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.OrdemServico;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface OrdemServicoService {


    @Headers("Accept: application/json")
    @POST("/api/ordemservico")
    Call<OrdemServico> postOrdemServico(@Body OrdemServico cliente);
    @Headers("Accept: application/json")
    @GET("/api/ordemservico")
    Call<List<OrdemServico>> getOrdemServico();


    @Headers("Accept: application/json")
    @PUT("/api/ordemservico")
    Call<OrdemServico> putServico(@Body OrdemServico ordemServico);


}
