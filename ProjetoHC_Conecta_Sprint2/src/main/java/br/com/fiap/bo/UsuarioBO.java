package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

    UsuarioDAO usuarioDAO;

    // Selecionar
    public ArrayList<Usuario> selecionarBo() throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        return (ArrayList<Usuario>) usuarioDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        // Regra de Negócio: Criptografar senha antes de salvar
        // (Simples exemplo, o ideal é usar uma biblioteca como BCrypt)
        // String senhaHash = new BCryptPasswordEncoder().encode(usuario.getDs_senha());
        // usuario.setDs_senha(senhaHash);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserir(usuario);
    }

    // Atualizar
    public void atualizarBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.atualizar(usuario);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deletar(id);
    }
}