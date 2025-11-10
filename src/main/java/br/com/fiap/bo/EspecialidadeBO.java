package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

public class EspecialidadeBO {

    EspecialidadeDAO especialidadeDAO;

    // Selecionar
    public ArrayList<Especialidade> selecionarBo() throws ClassNotFoundException, SQLException {
        especialidadeDAO = new EspecialidadeDAO();
        return (ArrayList<Especialidade>) especialidadeDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Especialidade especialidade) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        especialidadeDAO.inserir(especialidade);
    }

    // Atualizar
    public void atualizarBo(Especialidade especialidade) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        especialidadeDAO.atualizar(especialidade);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        especialidadeDAO.deletar(id);
    }
}
