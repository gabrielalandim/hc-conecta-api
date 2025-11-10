package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteInserirPaciente {

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
            return new Date(); // Retorna data atual em caso de erro
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Paciente objPaciente = new Paciente();
        PacienteDAO dao = new PacienteDAO();

        // Coletando dados com JOptionPane
        objPaciente.setNm_paciente(texto("Informe o Nome do Paciente"));
        objPaciente.setNr_cpf(texto("Informe o CPF"));
        objPaciente.setDt_nascimento(data("Data de Nascimento (dd/MM/yyyy)"));
        objPaciente.setDs_email(texto("Informe o E-mail"));
        objPaciente.setNr_telefone(texto("Informe o Telefone"));
        objPaciente.setDs_cep(texto("Informe o CEP (só números)"));
        objPaciente.setId_usuario(inteiro("Informe o ID de Usuário (deve existir na T_HC_USUARIO)"));

        System.out.println(dao.inserir(objPaciente));
    }
}
