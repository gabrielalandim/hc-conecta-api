package br.com.fiap.dao;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    public Connection minhaConexao;

    public EspecialidadeDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Especialidade especialidade) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_ESPECIALIDADE (id_especialidade, nm_especialidade) VALUES (SEQ_HC_ESPECIALIDADE.NEXTVAL, ?)");
        stmt.setString(1, especialidade.getNm_especialidade());
        stmt.execute();
        stmt.close();
        return "Especialidade cadastrada com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_ESPECIALIDADE WHERE id_especialidade = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Especialidade deletada com sucesso!";
    }

    // Update
    public String atualizar(Especialidade especialidade) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_ESPECIALIDADE SET nm_especialidade = ? WHERE id_especialidade = ?");
        stmt.setString(1, especialidade.getNm_especialidade());
        stmt.setInt(2, especialidade.getId_especialidade());
        stmt.executeUpdate();
        stmt.close();
        return "Especialidade atualizada com sucesso!";
    }

    // Select (Listar Todos)
    public List<Especialidade> selecionar() throws SQLException {
        List<Especialidade> listaEspecialidades = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_ESPECIALIDADE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setId_especialidade(rs.getInt(1));
            especialidade.setNm_especialidade(rs.getString(2));
            listaEspecialidades.add(especialidade);
        }
        rs.close();
        stmt.close();
        return listaEspecialidades;
    }
}
