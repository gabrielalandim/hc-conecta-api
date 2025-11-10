package br.com.fiap.beans;

import java.util.Date;

public class Paciente {

    private int id_paciente;
    private String nm_paciente;
    private String nr_cpf;
    private Date dt_nascimento;
    private String ds_email;
    private String nr_telefone;
    private int id_usuario;

    // --- CAMPO DE ENDEREÇO ÚNICO ---
    private String ds_cep;

    // Construtor padrão
    public Paciente() {
        super();
    }

    // Getters e Setters (Antigos)
    public int getId_paciente() {
        return id_paciente;
    }
    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    public String getNm_paciente() {
        return nm_paciente;
    }
    public void setNm_paciente(String nm_paciente) {
        this.nm_paciente = nm_paciente;
    }
    public String getNr_cpf() {
        return nr_cpf;
    }
    public void setNr_cpf(String nr_cpf) {
        this.nr_cpf = nr_cpf;
    }
    public Date getDt_nascimento() {
        return dt_nascimento;
    }
    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
    public String getDs_email() {
        return ds_email;
    }
    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }
    public String getNr_telefone() {
        return nr_telefone;
    }
    public void setNr_telefone(String nr_telefone) {
        this.nr_telefone = nr_telefone;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    // --- Getter e Setter (Novo) ---
    public String getDs_cep() {
        return ds_cep;
    }
    public void setDs_cep(String ds_cep) {
        this.ds_cep = ds_cep;
    }
}