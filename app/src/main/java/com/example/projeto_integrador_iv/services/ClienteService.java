package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Cliente;
import com.example.projeto_integrador_iv.models.Funcionario;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClienteService {

    @Headers("Accept: application/json")
    @POST("/api/cliente")
    Call<Cliente> postCliente(@Body Cliente cliente);

    @Headers("Accept: application/json")
    @GET("/api/cliente")
    Call<List<Cliente>> getCliente();

    @Headers("Accept: application/json")
    @PUT("/api/cliente")
    Call<Cliente> putCliente(@Body Cliente cliente);


}
