package br.com.fiap.beans;

public class Anamnese {

    private int id_anamnese;
    private int id_agendamento; // Chave Estrangeira para Agendamento
    private String ds_queixa_principal;
    private String ds_historico_doenca;
    private String ds_alergias;
    private String ds_observacoes;

    // Construtor padrão
    public Anamnese() {
        super();
    }

    // Construtor com campos
    public Anamnese(int id_anamnese, int id_agendamento, String ds_queixa_principal, String ds_historico_doenca, String ds_alergias, String ds_observacoes) {
        super();
        this.id_anamnese = id_anamnese;
        this.id_agendamento = id_agendamento;
        this.ds_queixa_principal = ds_queixa_principal;
        this.ds_historico_doenca = ds_historico_doenca;
        this.ds_alergias = ds_alergias;
        this.ds_observacoes = ds_observacoes;
    }

    // Getters e Setters
    public int getId_anamnese() {
        return id_anamnese;
    }
    public void setId_anamnese(int id_anamnese) {
        this.id_anamnese = id_anamnese;
    }
    public int getId_agendamento() {
        return id_agendamento;
    }
    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }
    public String getDs_queixa_principal() {
        return ds_queixa_principal;
    }
    public void setDs_queixa_principal(String ds_queixa_principal) {
        this.ds_queixa_principal = ds_queixa_principal;
    }
    public String getDs_historico_doenca() {
        return ds_historico_doenca;
    }
    public void setDs_historico_doenca(String ds_historico_doenca) {
        this.ds_historico_doenca = ds_historico_doenca;
    }
    public String getDs_alergias() {
        return ds_alergias;
    }
    public void setDs_alergias(String ds_alergias) {
        this.ds_alergias = ds_alergias;
    }
    public String getDs_observacoes() {
        return ds_observacoes;
    }
    public void setDs_observacoes(String ds_observacoes) {
        this.ds_observacoes = ds_observacoes;
    }
}