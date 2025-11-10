package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteAtualizarPaciente {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }
    static Date data(String j) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(JOptionPane.showInputDialog(j));
        } catch (ParseException e) {
            System.out.println("Erro ao formatar data, usando data atual.");
            e.printStackTrace();
            return new Date();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Paciente objPaciente = new Paciente();
        PacienteDAO dao = new PacienteDAO();

        // Coletando dados
        objPaciente.setId_paciente(inteiro("Informe o ID do Paciente a ser atualizado"));
        objPaciente.setNm_paciente(texto("Atualize o Nome"));
        objPaciente.setNr_cpf(texto("Atualize o CPF"));
        objPaciente.setDt_nascimento(data("Atualize a Data de Nascimento (dd/MM/yyyy)"));
        objPaciente.setDs_email(texto("Atualize o E-mail"));
        objPaciente.setNr_telefone(texto("Atualize o Telefone"));
        objPaciente.setDs_cep(texto("Atualize o CEP"));
        objPaciente.setId_usuario(inteiro("Atualize o ID de Usuário"));

        System.out.println(dao.atualizar(objPaciente));
    }
}
