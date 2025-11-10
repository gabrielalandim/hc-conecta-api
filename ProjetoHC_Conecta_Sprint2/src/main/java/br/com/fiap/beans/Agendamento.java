package br.com.fiap.beans;

import java.util.Date;

public class Agendamento {

    private int id_agendamento;
    private Date dt_agendamento;
    private String ds_status; // Ex: "AGENDADO", "REALIZADO", "CANCELADO"
    private int id_paciente; // Chave Estrangeira para Paciente
    private int id_profissional; // Chave Estrangeira para Profissional

    // Construtor padrão
    public Agendamento() {
        super();
    }

    // Construtor com campos
    public Agendamento(int id_agendamento, Date dt_agendamento, String ds_status, int id_paciente, int id_profissional) {
        super();
        this.id_agendamento = id_agendamento;
        this.dt_agendamento = dt_agendamento;
        this.ds_status = ds_status;
        this.id_paciente = id_paciente;
        this.id_profissional = id_profissional;
    }

    // Getters e Setters
    public int getId_agendamento() {
        return id_agendamento;
    }
    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }
    public Date getDt_agendamento() {
        return dt_agendamento;
    }
    public void setDt_agendamento(Date dt_agendamento) {
        this.dt_agendamento = dt_agendamento;
    }
    public String getDs_status() {
        return ds_status;
    }
    public void setDs_status(String ds_status) {
        this.ds_status = ds_status;
    }
    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public int getId_profissional() {
        return id_profissional;
    }
    public void setId_profissional(int id_profissional) {
        this.id_profissional = id_profissional;
    }
}
