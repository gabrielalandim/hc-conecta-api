package br.com.fiap.main;

import br.com.fiap.dao.AgendamentoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteDeletarAgendamento {

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AgendamentoDAO dao = new AgendamentoDAO();
        int idParaDeletar = inteiro("Informe o ID do Agendamento a ser deletado");

        System.out.println(dao.deletar(idParaDeletar));
    }
}
