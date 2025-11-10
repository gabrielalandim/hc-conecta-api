package br.com.fiap.beans;

public class Prescricao {

    private int id_prescricao;
    private int id_anamnese; // Chave Estrangeira para Anamnese
    private String ds_medicamento;
    private String ds_posologia; // Ex: "1 comprimido a cada 8 horas"
    private String ds_tratamento; // Ex: "Fisioterapia 2x por semana"

    // Construtor padrão
    public Prescricao() {
        super();
    }

    // Construtor com campos
    public Prescricao(int id_prescricao, int id_anamnese, String ds_medicamento, String ds_posologia, String ds_tratamento) {
        super();
        this.id_prescricao = id_prescricao;
        this.id_anamnese = id_anamnese;
        this.ds_medicamento = ds_medicamento;
        this.ds_posologia = ds_posologia;
        this.ds_tratamento = ds_tratamento;
    }

    // Getters e Setters
    public int getId_prescricao() {
        return id_prescricao;
    }
    public void setId_prescricao(int id_prescricao) {
        this.id_prescricao = id_prescricao;
    }
    public int getId_anamnese() {
        return id_anamnese;
    }
    public void setId_anamnese(int id_anamnese) {
        this.id_anamnese = id_anamnese;
    }
    public String getDs_medicamento() {
        return ds_medicamento;
    }
    public void setDs_medicamento(String ds_medicamento) {
        this.ds_medicamento = ds_medicamento;
    }
    public String getDs_posologia() {
        return ds_posologia;
    }
    public void setDs_posologia(String ds_posologia) {
        this.ds_posologia = ds_posologia;
    }
    public String getDs_tratamento() {
        return ds_tratamento;
    }
    public void setDs_tratamento(String ds_tratamento) {
        this.ds_tratamento = ds_tratamento;
    }
}
