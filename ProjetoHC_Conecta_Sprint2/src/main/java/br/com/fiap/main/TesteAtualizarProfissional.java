package br.com.fiap.main;

import br.com.fiap.beans.Profissional;
import br.com.fiap.dao.ProfissionalDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizarProfissional {

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

        // Coletando dados
        objProfissional.setId_profissional(inteiro("Informe o ID do Profissional a ser atualizado"));
        objProfissional.setNm_profissional(texto("Atualize o Nome"));
        objProfissional.setDs_email(texto("Atualize o E-mail"));
        objProfissional.setNr_conselho(texto("Atualize o Número do Conselho"));
        objProfissional.setId_especialidade(inteiro("Atualize o ID da Especialidade"));
        objProfissional.setId_usuario(inteiro("Atualize o ID do Usuário"));

        System.out.println(dao.atualizar(objProfissional));
    }
}
