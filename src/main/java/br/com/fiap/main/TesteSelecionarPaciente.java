package br.com.fiap.main;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarPaciente {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PacienteDAO dao = new PacienteDAO();
        List<Paciente> listaPacientes = (ArrayList<Paciente>) dao.selecionar();

        if (listaPacientes != null && !listaPacientes.isEmpty()) {
            System.out.println("--- LISTA DE PACIENTES ---");
            // foreach
            for (Paciente paciente : listaPacientes) {
                System.out.println(
                        "ID: " + paciente.getId_paciente() + " | " +
                                "Nome: " + paciente.getNm_paciente() + " | " +
                                "CPF: " + paciente.getNr_cpf() + " | " +
                                "CEP: " + paciente.getDs_cep()
                );
            }
        } else {
            System.out.println("Nenhum paciente encontrado.");
        }
    }
}
