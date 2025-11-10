package br.com.fiap.dao;

import br.com.fiap.beans.Profissional;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {

    public Connection minhaConexao;

    public ProfissionalDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Profissional profissional) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_PROFISSIONAL (id_profissional, nm_profissional, ds_email, nr_conselho, id_especialidade, id_usuario) " +
                        "VALUES (SEQ_HC_PROFISSIONAL.NEXTVAL, ?, ?, ?, ?, ?)");

        stmt.setString(1, profissional.getNm_profissional());
        stmt.setString(2, profissional.getDs_email());
        stmt.setString(3, profissional.getNr_conselho());
        stmt.setInt(4, profissional.getId_especialidade());
        stmt.setInt(5, profissional.getId_usuario());

        stmt.execute();
        stmt.close();
        return "Profissional cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_PROFISSIONAL WHERE id_profissional = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Profissional deletado com sucesso!";
    }

    // Update
    public String atualizar(Profissional profissional) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_PROFISSIONAL SET nm_profissional = ?, ds_email = ?, nr_conselho = ?, id_especialidade = ?, id_usuario = ? " +
                        "WHERE id_profissional = ?");

        stmt.setString(1, profissional.getNm_profissional());
        stmt.setString(2, profissional.getDs_email());
        stmt.setString(3, profissional.getNr_conselho());
        stmt.setInt(4, profissional.getId_especialidade());
        stmt.setInt(5, profissional.getId_usuario());
        stmt.setInt(6, profissional.getId_profissional());

        stmt.executeUpdate();
        stmt.close();
        return "Profissional atualizado com sucesso!";
    }

    // Select (Listar Todos)
    public List<Profissional> selecionar() throws SQLException {
        List<Profissional> listaProfissionais = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_PROFISSIONAL");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Profissional profissional = new Profissional();
            profissional.setId_profissional(rs.getInt(1));
            profissional.setNm_profissional(rs.getString(2));
            profissional.setDs_email(rs.getString(3));
            profissional.setNr_conselho(rs.getString(4));
            profissional.setId_especialidade(rs.getInt(5));
            profissional.setId_usuario(rs.getInt(6));
            listaProfissionais.add(profissional);
        }
        rs.close();
        stmt.close();
        return listaProfissionais;
    }
}
