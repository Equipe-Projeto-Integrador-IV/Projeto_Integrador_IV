package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Cliente;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ClienteService {

    @Headers("Accept: application/json")
    @POST("/api/cliente")
    Call<Cliente> postCliente(@Body Cliente cliente);

    @Headers("Accept: application/json")
    @GET("/api/cliente")
    Call<List<Cliente>> getCliente();


}
