package com.example.projeto_integrador_iv.services;

import com.example.projeto_integrador_iv.models.Agendamento;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AgendamentoService {

    @Headers("Accept: application/json")
    @POST("/api/agendamento")
    Call<Agendamento> postAgendamento(@Body Agendamento cliente);

    @Headers("Accept: application/json")
    @GET("/api/agendamento")
    Call<List<Agendamento>> getAgendamento();

}
