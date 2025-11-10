package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizarUsuario {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Usuario objUsuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        // Coletando dados
        objUsuario.setId_usuario(inteiro("Informe o ID do Usuário a ser atualizado"));
        objUsuario.setDs_login(texto("Atualize o Login"));
        objUsuario.setDs_senha(texto("Atualize a Senha"));
        objUsuario.setDs_tipo_usuario(texto("Atualize o Tipo de Usuário"));

        System.out.println(dao.atualizar(objUsuario));
    }
}
