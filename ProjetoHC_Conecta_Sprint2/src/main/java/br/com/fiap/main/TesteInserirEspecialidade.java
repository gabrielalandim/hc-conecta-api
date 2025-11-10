package br.com.fiap.main;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class TesteInserirEspecialidade {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Especialidade objEspecialidade = new Especialidade();
        EspecialidadeDAO dao = new EspecialidadeDAO();

        // Coletando dados com JOptionPane
        objEspecialidade.setNm_especialidade(texto("Nome da Especialidade (Ex: Cardiologia)"));

        System.out.println(dao.inserir(objEspecialidade));
    }
}
