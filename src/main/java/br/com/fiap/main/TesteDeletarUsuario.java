package br.com.fiap.main;

import br.com.fiap.dao.UsuarioDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarUsuario {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDAO dao = new UsuarioDAO();
        int idParaDeletar = inteiro("Informe o ID do Usuário a ser deletado");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
