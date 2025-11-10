package br.com.fiap.main;

import br.com.fiap.beans.Profissional;
import br.com.fiap.dao.ProfissionalDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirProfissional {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Profissional objProfissional = new Profissional();
        ProfissionalDAO dao = new ProfissionalDAO();

        // Coletando dados com JOptionPane
        objProfissional.setNm_profissional(texto("Nome do Profissional"));
        objProfissional.setDs_email(texto("E-mail do Profissional"));
        objProfissional.setNr_conselho(texto("Número do Conselho (Ex: CRM, CRP, Coren)"));
        objProfissional.setId_especialidade(inteiro("ID da Especialidade (deve existir)"));
        objProfissional.setId_usuario(inteiro("ID do Usuário (deve existir)"));

        System.out.println(dao.inserir(objProfissional));
    }
}
