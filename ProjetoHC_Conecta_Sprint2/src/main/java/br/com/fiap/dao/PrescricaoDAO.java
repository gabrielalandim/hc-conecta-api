package br.com.fiap.dao;

import br.com.fiap.beans.Prescricao;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescricaoDAO {

    public Connection minhaConexao;

    public PrescricaoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Prescricao prescricao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_PRESCRICAO (id_prescricao, id_anamnese, ds_medicamento, ds_posologia, ds_tratamento) " +
                        "VALUES (SEQ_HC_PRESCRICAO.NEXTVAL, ?, ?, ?, ?)");

        stmt.setInt(1, prescricao.getId_anamnese());
        stmt.setString(2, prescricao.getDs_medicamento());
        stmt.setString(3, prescricao.getDs_posologia());
        stmt.setString(4, prescricao.getDs_tratamento());

        stmt.execute();
        stmt.close();
        return "Prescrição cadastrada com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_PRESCRICAO WHERE id_prescricao = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Prescrição deletada com sucesso!";
    }

    // Update
    public String atualizar(Prescricao prescricao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_PRESCRICAO SET id_anamnese = ?, ds_medicamento = ?, ds_posologia = ?, ds_tratamento = ? " +
                        "WHERE id_prescricao = ?");

        stmt.setInt(1, prescricao.getId_anamnese());
        stmt.setString(2, prescricao.getDs_medicamento());
        stmt.setString(3, prescricao.getDs_posologia());
        stmt.setString(4, prescricao.getDs_tratamento());
        stmt.setInt(5, prescricao.getId_prescricao());

        stmt.executeUpdate();
        stmt.close();
        return "Prescrição atualizada com sucesso!";
    }

    // Select (Listar Todos)
    public List<Prescricao> selecionar() throws SQLException {
        List<Prescricao> listaPrescricoes = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_PRESCRICAO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prescricao prescricao = new Prescricao();
            prescricao.setId_prescricao(rs.getInt(1));
            prescricao.setId_anamnese(rs.getInt(2));
            prescricao.setDs_medicamento(rs.getString(3));
            prescricao.setDs_posologia(rs.getString(4));
            prescricao.setDs_tratamento(rs.getString(5));
            listaPrescricoes.add(prescricao);
        }
        rs.close();
        stmt.close();
        return listaPrescricoes;
    }
}
