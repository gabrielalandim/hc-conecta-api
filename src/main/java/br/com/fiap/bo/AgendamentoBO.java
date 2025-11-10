package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;

public class AgendamentoBO {

    AgendamentoDAO agendamentoDAO;

    // Selecionar
    public ArrayList<Agendamento> selecionarBo() throws ClassNotFoundException, SQLException {
        agendamentoDAO = new AgendamentoDAO();
        return (ArrayList<Agendamento>) agendamentoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        // Regra de Negócio: Validar se a data do agendamento é futura.
        // Regra de Negócio: Validar se o profissional tem horário vago.
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamento.setDs_status("AGENDADO"); // Forçar status inicial
        agendamentoDAO.inserir(agendamento);
    }

    // Atualizar
    public void atualizarBo(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.atualizar(agendamento);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        agendamentoDAO.deletar(id);
    }
}