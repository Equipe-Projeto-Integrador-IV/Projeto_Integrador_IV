package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Agendamento;
import com.example.projeto_integrador_iv.models.Servico;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AgendamentoService {

    @Headers("Accept: application/json")
    @POST("/api/agendamento")
    Call<Agendamento> postAgendamento(@Body Agendamento agendamento);

    @Headers("Accept: application/json")
    @GET("/api/agendamento")
    Call<List<Agendamento>> getAgendamento();

    @Headers("Accept: application/json")
    @PUT("/api/agendamento")
    Call<Agendamento> putAgendamento(@Body Agendamento agendamento);

}
