package br.com.fiap.main;

import br.com.fiap.beans.Prescricao;
import br.com.fiap.dao.PrescricaoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizarPrescricao {

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

        // Coletando dados
        objPrescricao.setId_prescricao(inteiro("Informe o ID da Prescrição a ser atualizada"));
        objPrescricao.setId_anamnese(inteiro("Atualize o ID da Anamnese"));
        objPrescricao.setDs_medicamento(texto("Atualize o Medicamento"));
        objPrescricao.setDs_posologia(texto("Atualize a Posologia"));
        objPrescricao.setDs_tratamento(texto("Atualize o Tratamento"));

        System.out.println(dao.atualizar(objPrescricao));
    }
}
