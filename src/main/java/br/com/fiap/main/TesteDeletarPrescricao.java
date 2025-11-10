package br.com.fiap.main;

import br.com.fiap.dao.PrescricaoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarPrescricao {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PrescricaoDAO dao = new PrescricaoDAO();
        int idParaDeletar = inteiro("Informe o ID da Prescrição a ser deletada");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
