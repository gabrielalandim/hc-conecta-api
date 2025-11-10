package br.com.fiap.beans;

public class Usuario {

    private int id_usuario;
    private String ds_login; // Pode ser o email ou um username
    private String ds_senha;
    private String ds_tipo_usuario; // Ex: "PACIENTE", "PROFISSIONAL"

    // Construtor padrão
    public Usuario() {
        super();
    }

    // Construtor com campos
    public Usuario(int id_usuario, String ds_login, String ds_senha, String ds_tipo_usuario) {
        super();
        this.id_usuario = id_usuario;
        this.ds_login = ds_login;
        this.ds_senha = ds_senha;
        this.ds_tipo_usuario = ds_tipo_usuario;
    }

    // Getters e Setters
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getDs_login() {
        return ds_login;
    }
    public void setDs_login(String ds_login) {
        this.ds_login = ds_login;
    }
    public String getDs_senha() {
        return ds_senha;
    }
    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }
    public String getDs_tipo_usuario() {
        return ds_tipo_usuario;
    }
    public void setDs_tipo_usuario(String ds_tipo_usuario) {
        this.ds_tipo_usuario = ds_tipo_usuario;
    }
}