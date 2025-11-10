package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarUsuario {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> listaUsuarios = (ArrayList<Usuario>) dao.selecionar();

        if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
            System.out.println("--- LISTA DE USUÁRIOS ---");
            // foreach
            for (Usuario usuario : listaUsuarios) {
                System.out.println(
                        "ID: " + usuario.getId_usuario() + " | " +
                                "Login: " + usuario.getDs_login() + " | " +
                                "Tipo: " + usuario.getDs_tipo_usuario()
                        // Não exibir a senha (campo sensível)
                );
            }
        } else {
            System.out.println("Nenhum usuário encontrado.");
        }
    }
}
