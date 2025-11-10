package br.com.fiap.main;

import br.com.fiap.beans.Anamnese;
import br.com.fiap.dao.AnamneseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarAnamnese {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        AnamneseDAO dao = new AnamneseDAO();
        List<Anamnese> listaAnamneses = (ArrayList<Anamnese>) dao.selecionar();

        if (listaAnamneses != null && !listaAnamneses.isEmpty()) {
            System.out.println("--- LISTA DE ANAMNESES ---");
            // foreach
            for (Anamnese anamnese : listaAnamneses) {
                System.out.println(
                        "ID: " + anamnese.getId_anamnese() + " | " +
                                "ID Agendamento: " + anamnese.getId_agendamento() + " | " +
                                "Queixa: " + anamnese.getDs_queixa_principal()
                );
            }
        } else {
            System.out.println("Nenhuma anamnese encontrada.");
        }
    }
}
