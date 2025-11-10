package br.com.fiap.main;

import br.com.fiap.beans.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarEspecialidade {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EspecialidadeDAO dao = new EspecialidadeDAO();
        List<Especialidade> listaEspecialidades = (ArrayList<Especialidade>) dao.selecionar();

        if (listaEspecialidades != null && !listaEspecialidades.isEmpty()) {
            System.out.println("--- LISTA DE ESPECIALIDADES ---");
            // foreach
            for (Especialidade especialidade : listaEspecialidades) {
                System.out.println(
                        "ID: " + especialidade.getId_especialidade() + " | " +
                                "Nome: " + especialidade.getNm_especialidade()
                );
            }
        } else {
            System.out.println("Nenhuma especialidade encontrada.");
        }
    }
}
