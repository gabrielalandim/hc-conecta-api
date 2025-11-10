package br.com.fiap.dao;

import br.com.fiap.beans.Anamnese;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnamneseDAO {

    public Connection minhaConexao;

    public AnamneseDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Anamnese anamnese) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_ANAMNESE (id_anamnese, id_agendamento, ds_queixa_principal, ds_historico_doenca, ds_alergias, ds_observacoes) " +
                        "VALUES (SEQ_HC_ANAMNESE.NEXTVAL, ?, ?, ?, ?, ?)");

        stmt.setInt(1, anamnese.getId_agendamento());
        stmt.setString(2, anamnese.getDs_queixa_principal());
        stmt.setString(3, anamnese.getDs_historico_doenca());
        stmt.setString(4, anamnese.getDs_alergias());
        stmt.setString(5, anamnese.getDs_observacoes());

        stmt.execute();
        stmt.close();
        return "Anamnese cadastrada com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_ANAMNESE WHERE id_anamnese = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Anamnese deletada com sucesso!";
    }

    // Update
    public String atualizar(Anamnese anamnese) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_ANAMNESE SET id_agendamento = ?, ds_queixa_principal = ?, ds_historico_doenca = ?, ds_alergias = ?, ds_observacoes = ? " +
                        "WHERE id_anamnese = ?");

        stmt.setInt(1, anamnese.getId_agendamento());
        stmt.setString(2, anamnese.getDs_queixa_principal());
        stmt.setString(3, anamnese.getDs_historico_doenca());
        stmt.setString(4, anamnese.getDs_alergias());
        stmt.setString(5, anamnese.getDs_observacoes());
        stmt.setInt(6, anamnese.getId_anamnese());

        stmt.executeUpdate();
        stmt.close();
        return "Anamnese atualizada com sucesso!";
    }

    // Select (Listar Todos)
    public List<Anamnese> selecionar() throws SQLException {
        List<Anamnese> listaAnamneses = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_ANAMNESE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Anamnese anamnese = new Anamnese();
            anamnese.setId_anamnese(rs.getInt(1));
            anamnese.setId_agendamento(rs.getInt(2));
            anamnese.setDs_queixa_principal(rs.getString(3));
            anamnese.setDs_historico_doenca(rs.getString(4));
            anamnese.setDs_alergias(rs.getString(5));
            anamnese.setDs_observacoes(rs.getString(6));
            listaAnamneses.add(anamnese);
        }
        rs.close();
        stmt.close();
        return listaAnamneses;
    }
}
