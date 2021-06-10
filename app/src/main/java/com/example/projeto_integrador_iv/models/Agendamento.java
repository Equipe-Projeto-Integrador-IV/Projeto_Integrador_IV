package com.example.projeto_integrador_iv.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento implements Serializable {
    private Long id;
    private Date data;
    private Date hora;
    private String status;
    private String obs;
    private Cliente cliente;
    private Funcionario respAgendamento;
    private Servico servico;

    public Agendamento() {

    }

    public Agendamento(Long id, Date date, Date hora, String status, String obs,
                       Funcionario respAgendamento, Servico servico) {
        this.id = id;
        this.data = date;
        this.hora = hora;
        this.status = status;
        this.obs = obs;
        this.respAgendamento = respAgendamento;
        this.servico = servico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setDate(Date date) {
        this.data = date;
    }

    public Date getHora() {

        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getRespAgendamento() {
        return respAgendamento;
    }

    public void setRespAgendamento(Funcionario respAgendamento) {
        this.respAgendamento = respAgendamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(this.data);
        return "Agendamento{" +
                "id=" + id +
                ", date=" + data +
                ", hora=" + hora +
                ", status='" + status + '\'' +
                ", obs='" + obs + '\'' +
                ", cliente=" + cliente +
                ", respAgendamento=" + respAgendamento +
                ", servico=" + servico +
                '}';
    }
}
