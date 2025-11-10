package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Connection minhaConexao;

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO T_HC_USUARIO (id_usuario, ds_login, ds_senha, ds_tipo_usuario) VALUES (SEQ_HC_USUARIO.NEXTVAL, ?, ?, ?)");

        stmt.setString(1, usuario.getDs_login());
        stmt.setString(2, usuario.getDs_senha()); // Idealmente, a senha deve ser criptografada (hash) antes de chegar aqui.
        stmt.setString(3, usuario.getDs_tipo_usuario());

        stmt.execute();
        stmt.close();
        return "Usuário cadastrado com sucesso!";
    }

    // Delete
    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM T_HC_USUARIO WHERE id_usuario = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return "Usuário deletado com sucesso!";
    }

    // Update
    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE T_HC_USUARIO SET ds_login = ?, ds_senha = ?, ds_tipo_usuario = ? WHERE id_usuario = ?");

        stmt.setString(1, usuario.getDs_login());
        stmt.setString(2, usuario.getDs_senha());
        stmt.setString(3, usuario.getDs_tipo_usuario());
        stmt.setInt(4, usuario.getId_usuario());

        stmt.executeUpdate();
        stmt.close();
        return "Usuário atualizado com sucesso!";
    }

    // Select (Listar Todos)
    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM T_HC_USUARIO");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId_usuario(rs.getInt(1));
            usuario.setDs_login(rs.getString(2));
            usuario.setDs_senha(rs.getString(3)); // Não é boa prática retornar a senha.
            usuario.setDs_tipo_usuario(rs.getString(4));
            listaUsuarios.add(usuario);
        }
        rs.close();
        stmt.close();
        return listaUsuarios;
    }
}
