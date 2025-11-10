package br.com.fiap.main;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.excecoes.ExcecoesConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws ExcecoesConexao, SQLException, ClassNotFoundException {

        Connection cn = null;

        try {
            cn = new ConexaoFactory().conexao();
            System.out.println("Conectado com o banco de dados HC CONECTA com sucesso!");
        } catch (Exception e) {
            // Usa a classe de Exceção customizada
            throw new ExcecoesConexao(e);
        } finally {
            System.out.println("Teste de conexão finalizado.");
            if (cn != null) {
                cn.close();
            }
        }
    }
}
