package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Profissional;
import br.com.fiap.dao.ProfissionalDAO;

public class ProfissionalBO {

    ProfissionalDAO profissionalDAO;

    // Selecionar
    public ArrayList<Profissional> selecionarBo() throws ClassNotFoundException, SQLException {
        profissionalDAO = new ProfissionalDAO();
        return (ArrayList<Profissional>) profissionalDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Profissional profissional) throws ClassNotFoundException, SQLException {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        profissionalDAO.inserir(profissional);
    }

    // Atualizar
    public void atualizarBo(Profissional profissional) throws ClassNotFoundException, SQLException {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        profissionalDAO.atualizar(profissional);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();
        profissionalDAO.deletar(id);
    }
}
