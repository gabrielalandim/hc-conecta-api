package br.com.fiap.main;

import br.com.fiap.beans.Prescricao;
import br.com.fiap.dao.PrescricaoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarPrescricao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PrescricaoDAO dao = new PrescricaoDAO();
        List<Prescricao> listaPrescricoes = (ArrayList<Prescricao>) dao.selecionar();

        if (listaPrescricoes != null && !listaPrescricoes.isEmpty()) {
            System.out.println("--- LISTA DE PRESCRIÇÕES ---");
            // foreach
            for (Prescricao prescricao : listaPrescricoes) {
                System.out.println(
                        "ID: " + prescricao.getId_prescricao() + " | " +
                                "ID Anamnese: " + prescricao.getId_anamnese() + " | " +
                                "Medicamento: " + prescricao.getDs_medicamento()
                );
            }
        } else {
            System.out.println("Nenhuma prescrição encontrada.");
        }
    }
}
