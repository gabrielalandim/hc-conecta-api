package br.com.fiap.dao;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; // Usar Timestamp para data e hora
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    public Connection minhaConexao;

    public AgendamentoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_AGENDAMENTO (id_agendamento, dt_agendamento, ds_status, id_paciente, id_profissional) " +
                        "VALUES (SEQ_HC_AGENDAMENTO.NEXTVAL, ?, ?, ?, ?)");

        // Usar Timestamp para java.util.Date
        stmt.setTimestamp(1, new Timestamp(agendamento.getDt_agendamento().getTime()));
        stmt.setString(2, agendamento.getDs_status());
        stmt.setInt(3, agendamento.getId_paciente());
        stmt.setInt(4, agendamento.getId_profissional());

        stmt.execute();
        stmt.close();
        return "Agendamento cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_AGENDAMENTO WHERE id_agendamento = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Agendamento deletado com sucesso!";
    }

    // Update
    public String atualizar(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_AGENDAMENTO SET dt_agendamento = ?, ds_status = ?, id_paciente = ?, id_profissional = ? " +
                        "WHERE id_agendamento = ?");

        stmt.setTimestamp(1, new Timestamp(agendamento.getDt_agendamento().getTime()));
        stmt.setString(2, agendamento.getDs_status());
        stmt.setInt(3, agendamento.getId_paciente());
        stmt.setInt(4, agendamento.getId_profissional());
        stmt.setInt(5, agendamento.getId_agendamento());

        stmt.executeUpdate();
        stmt.close();
        return "Agendamento atualizado com sucesso!";
    }

    // Select (Listar Todos)
    public List<Agendamento> selecionar() throws SQLException {
        List<Agendamento> listaAgendamentos = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_AGENDAMENTO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Agendamento agendamento = new Agendamento();
            agendamento.setId_agendamento(rs.getInt(1));
            agendamento.setDt_agendamento(rs.getTimestamp(2)); // Obter Timestamp
            agendamento.setDs_status(rs.getString(3));
            agendamento.setId_paciente(rs.getInt(4));
            agendamento.setId_profissional(rs.getInt(5));
            listaAgendamentos.add(agendamento);
        }
        rs.close();
        stmt.close();
        return listaAgendamentos;
    }
}
