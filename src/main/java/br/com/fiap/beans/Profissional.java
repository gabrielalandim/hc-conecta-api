package br.com.fiap.beans;

public class Profissional {

    private int id_profissional;
    private String nm_profissional;
    private String ds_email;
    private String nr_conselho; // Ex: CRM, Coren, CRP
    private int id_especialidade; // Chave Estrangeira para Especialidade
    private int id_usuario; // Chave Estrangeira para Usuario

    // Construtor padrão
    public Profissional() {
        super();
    }

    // Construtor com campos
    public Profissional(int id_profissional, String nm_profissional, String ds_email, String nr_conselho, int id_especialidade, int id_usuario) {
        super();
        this.id_profissional = id_profissional;
        this.nm_profissional = nm_profissional;
        this.ds_email = ds_email;
        this.nr_conselho = nr_conselho;
        this.id_especialidade = id_especialidade;
        this.id_usuario = id_usuario;
    }

    // Getters e Setters
    public int getId_profissional() {
        return id_profissional;
    }
    public void setId_profissional(int id_profissional) {
        this.id_profissional = id_profissional;
    }
    public String getNm_profissional() {
        return nm_profissional;
    }
    public void setNm_profissional(String nm_profissional) {
        this.nm_profissional = nm_profissional;
    }
    public String getDs_email() {
        return ds_email;
    }
    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }
    public String getNr_conselho() {
        return nr_conselho;
    }
    public void setNr_conselho(String nr_conselho) {
        this.nr_conselho = nr_conselho;
    }
    public int getId_especialidade() {
        return id_especialidade;
    }
    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}