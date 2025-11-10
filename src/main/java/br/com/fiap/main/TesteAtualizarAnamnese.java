package br.com.fiap.main;

import br.com.fiap.beans.Anamnese;
import br.com.fiap.dao.AnamneseDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizarAnamnese {

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

        // Coletando dados
        objAnamnese.setId_anamnese(inteiro("Informe o ID da Anamnese a ser atualizada"));
        objAnamnese.setId_agendamento(inteiro("Atualize o ID do Agendamento"));
        objAnamnese.setDs_queixa_principal(texto("Atualize a Queixa Principal"));
        objAnamnese.setDs_historico_doenca(texto("Atualize o Histórico da Doença"));
        objAnamnese.setDs_alergias(texto("Atualize as Alergias"));
        objAnamnese.setDs_observacoes(texto("Atualize as Observações"));

        System.out.println(dao.atualizar(objAnamnese));
    }
}
