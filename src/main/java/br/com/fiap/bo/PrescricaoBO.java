package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Prescricao;
import br.com.fiap.dao.PrescricaoDAO;

public class PrescricaoBO {

    PrescricaoDAO prescricaoDAO;

    // Selecionar
    public ArrayList<Prescricao> selecionarBo() throws ClassNotFoundException, SQLException {
        prescricaoDAO = new PrescricaoDAO();
        return (ArrayList<Prescricao>) prescricaoDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Prescricao prescricao) throws ClassNotFoundException, SQLException {
        PrescricaoDAO prescricaoDAO = new PrescricaoDAO();
        prescricaoDAO.inserir(prescricao);
    }

    // Atualizar
    public void atualizarBo(Prescricao prescricao) throws ClassNotFoundException, SQLException {
        PrescricaoDAO prescricaoDAO = new PrescricaoDAO();
        prescricaoDAO.atualizar(prescricao);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        PrescricaoDAO prescricaoDAO = new PrescricaoDAO();
        prescricaoDAO.deletar(id);
    }
}
