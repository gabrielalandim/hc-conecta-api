package br.com.fiap.main;

import br.com.fiap.dao.PacienteDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarPaciente {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PacienteDAO dao = new PacienteDAO();
        int idParaDeletar = inteiro("Informe o ID do Paciente a ser deletado");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
