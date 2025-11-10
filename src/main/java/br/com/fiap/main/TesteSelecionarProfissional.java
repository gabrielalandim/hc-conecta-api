package br.com.fiap.main;

import br.com.fiap.beans.Profissional;
import br.com.fiap.dao.ProfissionalDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarProfissional {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProfissionalDAO dao = new ProfissionalDAO();
        List<Profissional> listaProfissionais = (ArrayList<Profissional>) dao.selecionar();

        if (listaProfissionais != null && !listaProfissionais.isEmpty()) {
            System.out.println("--- LISTA DE PROFISSIONAIS ---");
            // foreach
            for (Profissional profissional : listaProfissionais) {
                System.out.println(
                        "ID: " + profissional.getId_profissional() + " | " +
                                "Nome: " + profissional.getNm_profissional() + " | " +
                                "Email: " + profissional.getDs_email() + " | " +
                                "Conselho: " + profissional.getNr_conselho()
                );
            }
        } else {
            System.out.println("Nenhum profissional encontrado.");
        }
    }
}
