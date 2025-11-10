package br.com.fiap.main;

import br.com.fiap.dao.AnamneseDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarAnamnese {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AnamneseDAO dao = new AnamneseDAO();
        int idParaDeletar = inteiro("Informe o ID da Anamnese a ser deletada");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
