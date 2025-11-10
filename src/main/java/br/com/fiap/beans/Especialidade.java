package br.com.fiap.beans;

public class Especialidade {

    private int id_especialidade;
    private String nm_especialidade; // Ex: Cardiologia, Psicologia

    // Construtor padrão
    public Especialidade() {
        super();
    }

    // Construtor com campos
    public Especialidade(int id_especialidade, String nm_especialidade) {
        super();
        this.id_especialidade = id_especialidade;
        this.nm_especialidade = nm_especialidade;
    }

    // Getters e Setters
    public int getId_especialidade() {
        return id_especialidade;
    }
    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }
    public String getNm_especialidade() {
        return nm_especialidade;
    }
    public void setNm_especialidade(String nm_especialidade) {
        this.nm_especialidade = nm_especialidade;
    }
}
