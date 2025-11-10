package br.com.fiap.main;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteInserirAgendamento {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }
    // Helper para data e hora
    static Timestamp dataHora(String j) {
        // Padrão para data E hora
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date dataParseada = sdf.parse(JOptionPane.showInputDialog(j));
            return new Timestamp(dataParseada.getTime());
        } catch (ParseException e) {
            System.out.println("Erro ao formatar data/hora, usando data atual.");
            e.printStackTrace();
            return new Timestamp(new Date().getTime()); // Retorna data atual em caso de erro
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Agendamento objAgendamento = new Agendamento();
        AgendamentoDAO dao = new AgendamentoDAO();

        // Coletando dados com JOptionPane
        objAgendamento.setDt_agendamento(dataHora("Data e Hora (dd/MM/yyyy HH:mm)"));
        objAgendamento.setDs_status(texto("Status (Ex: AGENDADO)"));
        objAgendamento.setId_paciente(inteiro("ID do Paciente (deve existir)"));
        objAgendamento.setId_profissional(inteiro("ID do Profissional (deve existir)"));

        System.out.println(dao.inserir(objAgendamento));
    }
}
