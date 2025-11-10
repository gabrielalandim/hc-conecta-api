package br.com.fiap.main;

import br.com.fiap.dao.ProfissionalDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarProfissional {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProfissionalDAO dao = new ProfissionalDAO();
        int idParaDeletar = inteiro("Informe o ID do Profissional a ser deletado");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
