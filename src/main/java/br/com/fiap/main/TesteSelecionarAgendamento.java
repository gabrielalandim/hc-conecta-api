package br.com.fiap.main;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarAgendamento {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AgendamentoDAO dao = new AgendamentoDAO();
        List<Agendamento> listaAgendamentos = (ArrayList<Agendamento>) dao.selecionar();

        if (listaAgendamentos != null && !listaAgendamentos.isEmpty()) {
            System.out.println("--- LISTA DE AGENDAMENTOS ---");
            // foreach
            for (Agendamento agendamento : listaAgendamentos) {
                System.out.println(
                        "ID: " + agendamento.getId_agendamento() + " | " +
                                "Data/Hora: " + agendamento.getDt_agendamento() + " | " +
                                "Status: " + agendamento.getDs_status() + " | " +
                                "ID Paciente: " + agendamento.getId_paciente() + " | " +
                                "ID Profissional: " + agendamento.getId_profissional()
                );
            }
        } else {
            System.out.println("Nenhum agendamento encontrado.");
        }
    }
}
