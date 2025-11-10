package br.com.fiap.main;

import br.com.fiap.beans.Anamnese;
import br.com.fiap.dao.AnamneseDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirAnamnese {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Anamnese objAnamnese = new Anamnese();
        AnamneseDAO dao = new AnamneseDAO();

        // Coletando dados com JOptionPane
        objAnamnese.setId_agendamento(inteiro("ID do Agendamento (deve existir)"));
        objAnamnese.setDs_queixa_principal(texto("Queixa Principal"));
        objAnamnese.setDs_historico_doenca(texto("Histórico da Doença"));
        objAnamnese.setDs_alergias(texto("Alergias"));
        objAnamnese.setDs_observacoes(texto("Observações"));

        System.out.println(dao.inserir(objAnamnese));
    }
}
