package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirUsuario {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Usuario objUsuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        // Coletando dados com JOptionPane
        objUsuario.setDs_login(texto("Login (email ou username)"));
        objUsuario.setDs_senha(texto("Senha")); // Lembre-se que o BO deveria criptografar isso
        objUsuario.setDs_tipo_usuario(texto("Tipo de Usuário (Ex: PACIENTE ou PROFISSIONAL)"));

        System.out.println(dao.inserir(objUsuario));
    }
}