package br.com.fiap.main;

import br.com.fiap.beans.Prescricao;
import br.com.fiap.dao.PrescricaoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirPrescricao {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Prescricao objPrescricao = new Prescricao();
        PrescricaoDAO dao = new PrescricaoDAO();

        // Coletando dados com JOptionPane
        objPrescricao.setId_anamnese(inteiro("ID da Anamnese (deve existir)"));
        objPrescricao.setDs_medicamento(texto("Medicamento (Ex: Dipirona 500mg)"));
        objPrescricao.setDs_posologia(texto("Posologia (Ex: 1 comp. a cada 8h)"));
        objPrescricao.setDs_tratamento(texto("Tratamento (Ex: Repouso por 3 dias)"));

        System.out.println(dao.inserir(objPrescricao));
    }
}
