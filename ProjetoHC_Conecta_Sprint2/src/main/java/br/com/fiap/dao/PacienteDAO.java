package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaConexao;

    public PacienteDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_PACIENTE (id_paciente, nm_paciente, nr_cpf, dt_nascimento, ds_email, nr_telefone, id_usuario, ds_cep) " +
                        "VALUES (SEQ_HC_PACIENTE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, paciente.getNm_paciente());
        stmt.setString(2, paciente.getNr_cpf());
        stmt.setDate(3, new java.sql.Date(paciente.getDt_nascimento().getTime()));
        stmt.setString(4, paciente.getDs_email());
        stmt.setString(5, paciente.getNr_telefone());
        stmt.setInt(6, paciente.getId_usuario());
        stmt.setString(7, paciente.getDs_cep()); // Único campo de endereço

        stmt.execute();
        stmt.close();
        return "Paciente cadastrado com sucesso!";
    }

    // Update
    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_PACIENTE SET nm_paciente = ?, nr_cpf = ?, dt_nascimento = ?, ds_email = ?, nr_telefone = ?, id_usuario = ?, ds_cep = ? " +
                        "WHERE id_paciente = ?");

        stmt.setString(1, paciente.getNm_paciente());
        stmt.setString(2, paciente.getNr_cpf());
        stmt.setDate(3, new java.sql.Date(paciente.getDt_nascimento().getTime()));
        stmt.setString(4, paciente.getDs_email());
        stmt.setString(5, paciente.getNr_telefone());
        stmt.setInt(6, paciente.getId_usuario());
        stmt.setString(7, paciente.getDs_cep()); // Único campo de endereço
        stmt.setInt(8, paciente.getId_paciente()); // WHERE

        stmt.executeUpdate();
        stmt.close();
        return "Paciente atualizado com sucesso!";
    }

    // Select (Listar Todos)
    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> listaPacientes = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_PACIENTE");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente paciente = new Paciente();
            paciente.setId_paciente(rs.getInt("id_paciente"));
            paciente.setNm_paciente(rs.getString("nm_paciente"));
            paciente.setNr_cpf(rs.getString("nr_cpf"));
            paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
            paciente.setDs_email(rs.getString("ds_email"));
            paciente.setNr_telefone(rs.getString("nr_telefone"));
            paciente.setId_usuario(rs.getInt("id_usuario"));
            paciente.setDs_cep(rs.getString("ds_cep")); // Único campo de endereço
            listaPacientes.add(paciente);
        }
        rs.close();
        stmt.close();
        return listaPacientes;
    }

    // --- NOVO MÉTODO ---
    // Select (Buscar Por ID) -
    public Paciente selecionarPorId(int id) throws SQLException {
        Paciente paciente = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_PACIENTE WHERE id_paciente = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            paciente.setId_paciente(rs.getInt("id_paciente"));
            paciente.setNm_paciente(rs.getString("nm_paciente"));
            paciente.setNr_cpf(rs.getString("nr_cpf"));
            paciente.setDt_nascimento(rs.getDate("dt_nascimento"));
            paciente.setDs_email(rs.getString("ds_email"));
            paciente.setNr_telefone(rs.getString("nr_telefone"));
            paciente.setId_usuario(rs.getInt("id_usuario"));
            paciente.setDs_cep(rs.getString("ds_cep"));
        }
        rs.close();
        stmt.close();
        return paciente; // Retorna o paciente encontrado ou null
    }

    // Delete (Permanece igual)
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_PACIENTE WHERE id_paciente = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Paciente deletado com sucesso!";
    }
}