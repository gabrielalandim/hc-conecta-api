package br.com.fiap.main;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteAtualizarAgendamento {

    // Helpers do JOptionPane
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }
    static Timestamp dataHora(String j) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Date dataParseada = sdf.parse(JOptionPane.showInputDialog(j));
            return new Timestamp(dataParseada.getTime());
        } catch (ParseException e) {
            System.out.println("Erro ao formatar data/hora, usando data atual.");
            e.printStackTrace();
            return new Timestamp(new Date().getTime());
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Agendamento objAgendamento = new Agendamento();
        AgendamentoDAO dao = new AgendamentoDAO();

        // Coletando dados
        objAgendamento.setId_agendamento(inteiro("Informe o ID do Agendamento a ser atualizado"));
        objAgendamento.setDt_agendamento(dataHora("Atualize a Data e Hora (dd/MM/yyyy HH:mm)"));
        objAgendamento.setDs_status(texto("Atualize o Status (Ex: REALIZADO)"));
        objAgendamento.setId_paciente(inteiro("Atualize o ID do Paciente"));
        objAgendamento.setId_profissional(inteiro("Atualize o ID do Profissional"));

        System.out.println(dao.atualizar(objAgendamento));
    }
}
