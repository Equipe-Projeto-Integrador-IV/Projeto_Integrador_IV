    package com.example.projeto_integrador_iv.models;

    import java.io.Serializable;
    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class OrdemServico implements Serializable {
        private Long id_os;
        private Date data_inicio;
        private Date data_fim;
        private Date hora_inicio;
        private Date hora_fim;
        private String status;
        private Float valor = 0f;
        private Agendamento agendamento;
        private Servico servico;
        private Funcionario respOS;
        private Funcionario execServico;

        public OrdemServico() {

        }

        public OrdemServico(Long id_os, Date data_inicio, Date data_fim, Date hora_inicio, Date hora_fim,
                            String status, Float valor, Agendamento agendamento, Servico servico,
                            Funcionario respOS, Funcionario execServico) {

            this.id_os = id_os;
            this.data_inicio = data_inicio;
            this.data_fim = data_fim;
            this.hora_inicio = hora_inicio;
            this.hora_fim = hora_fim;
            this.status = status;
            this.valor = valor;
            this.agendamento = agendamento;
            this.servico = servico;
            this.respOS = respOS;
            this.execServico = execServico;
        }

        public Long getId_os() {
            return id_os;
        }

        public void setId_os(Long id_os) {
            this.id_os = id_os;
        }

        public Date getData_inicio() {
            return data_inicio;
        }

        public void setData_inicio(Date data_inicio) {
            this.data_inicio = data_inicio;
        }

        public Date getData_fim() {
            return data_fim;
        }

        public void setData_fim(Date data_fim) {
            this.data_fim = data_fim;
        }

        public Date getHora_inicio() {
            return hora_inicio;
        }

        public void setHora_inicio(Date hora_inicio) {
            this.hora_inicio = hora_inicio;
        }

        public Date getHora_fim() {
            return hora_fim;
        }

        public void setHora_fim(Date hora_fim) {
            this.hora_fim = hora_fim;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Float getValor() {
            return valor;
        }

        public void setValor(Float valor) {
            this.valor = valor;
        }

        public Agendamento getAgendamento() {
            return agendamento;
        }

        public void setAgendamento(Agendamento agendamento) {
            this.agendamento = agendamento;
        }

        public Servico getServico() {
            return servico;
        }

        public void setServico(Servico servico) {
            this.servico = servico;
        }

        public Funcionario getRespOS() {
            return respOS;
        }

        public void setRespOS(Funcionario respOS) {
            this.respOS = respOS;
        }

        public Funcionario getExecServico() {
            return execServico;
        }

        public void setExecServico(Funcionario execServico) {
            this.execServico = execServico;
        }

        @Override
        public String toString() {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String data_inicio = this.data_inicio == null ? "" : df.format(this.data_inicio);
            String data_fim = this.data_fim == null ? "" : df.format(this.data_fim);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            String hora_inicio = this.hora_inicio == null ? "" : sdf.format(this.hora_inicio);
            String hora_fim = this.hora_fim == null ? "" : sdf.format(this.hora_fim);

            return "OrdemServico: " + "\n" +
                    "Id :" + id_os + "\n" +
                    "Data_Inicio :" + data_inicio + "\n" +
                    "Data_Fim: " + data_fim + "\n" +
                    "Hora_Inicio: " + hora_inicio + "\n" +
                    "Hora_Fim :" + hora_fim + "\n" +
                    "Status='" + status + '\n' +
                    "Valor :" + valor + "\n" +
                    "-----------------Dados Agendamento-------------------" + "\n" +
                    agendamento + "\n" +
                    "-----------------Dados Agendamento-------------------" + "\n" +
                    "\n" +
                    "-------------------Informa????es-------------------" + "\n" +
                    "Servi??o: " + servico.getNome() + "\n" +
                    "Respons??vel pela OS: " + respOS.getNome() + "\n" +
                    "Respons??vel pelo Servi??o: " + execServico.getNome() ;
        }
    }
