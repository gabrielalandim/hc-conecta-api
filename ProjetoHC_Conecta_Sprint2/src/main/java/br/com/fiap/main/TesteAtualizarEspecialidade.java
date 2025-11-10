package br.com.fiap.main;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteAtualizarEspecialidade {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Especialidade objEspecialidade = new Especialidade();
        EspecialidadeDAO dao = new EspecialidadeDAO();

        // Coletando dados
        objEspecialidade.setId_especialidade(inteiro("Informe o ID da Especialidade a ser atualizada"));
        objEspecialidade.setNm_especialidade(texto("Atualize o Nome da Especialidade"));

        System.out.println(dao.atualizar(objEspecialidade));
    }
}
