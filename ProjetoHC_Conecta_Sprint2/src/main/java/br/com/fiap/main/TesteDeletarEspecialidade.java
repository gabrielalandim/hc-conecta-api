package br.com.fiap.main;

import br.com.fiap.dao.EspecialidadeDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarEspecialidade {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EspecialidadeDAO dao = new EspecialidadeDAO();
        int idParaDeletar = inteiro("Informe o ID da Especialidade a ser deletada");

        System.out.println(dao.deletar(idParaDeletar));
    }
}