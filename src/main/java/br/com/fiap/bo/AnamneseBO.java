package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.Anamnese;
import br.com.fiap.dao.AnamneseDAO;

public class AnamneseBO {

    AnamneseDAO anamneseDAO;

    // Selecionar
    public ArrayList<Anamnese> selecionarBo() throws ClassNotFoundException, SQLException {
        anamneseDAO = new AnamneseDAO();
        return (ArrayList<Anamnese>) anamneseDAO.selecionar();
    }

    // Inserir
    public void inserirBo(Anamnese anamnese) throws ClassNotFoundException, SQLException {
        AnamneseDAO anamneseDAO = new AnamneseDAO();
        anamneseDAO.inserir(anamnese);
    }

    // Atualizar
    public void atualizarBo(Anamnese anamnese) throws ClassNotFoundException, SQLException {
        AnamneseDAO anamneseDAO = new AnamneseDAO();
        anamneseDAO.atualizar(anamnese);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        AnamneseDAO anamneseDAO = new AnamneseDAO();
        anamneseDAO.deletar(id);
    }
}
