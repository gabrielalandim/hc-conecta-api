package br.com.fiap.bo;

import java.io.IOException; // Importar IOException
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.api.Endereco;
import br.com.fiap.beans.Paciente;
import br.com.fiap.api.Endereco; // Importar o bean Endereco
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.services.ViaCepService; // Importar o serviço ViaCep

public class PacienteBO {

    private PacienteDAO pacienteDAO;
    private ViaCepService viaCepService; // Serviço ViaCep

    public PacienteBO() {
        this.viaCepService = new ViaCepService();
    }

    // Inserir (Simplificado)
    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        // A regra de negócio do ViaCep não está mais aqui
        pacienteDAO = new PacienteDAO();
        pacienteDAO.inserir(paciente);
    }

    // Atualizar (Simplificado)
    public void atualizarBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        // A regra de negócio do ViaCep não está mais aqui
        pacienteDAO = new PacienteDAO();
        pacienteDAO.atualizar(paciente);
    }

    // Selecionar (Permanece igual)
    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        return (ArrayList<Paciente>) pacienteDAO.selecionar();
    }

    // Deletar (Permanece igual)
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        pacienteDAO.deletar(id);
    }

    // --- NOVA REGRA DE NEGÓCIO ---
    // Buscar o endereço de um paciente específico usando ViaCep
    public Endereco selecionarEnderecoPorIdBo(int id) throws ClassNotFoundException, SQLException, IOException {

        // 1. Buscar o paciente pelo ID para descobrir seu CEP
        pacienteDAO = new PacienteDAO();
        Paciente paciente = pacienteDAO.selecionarPorId(id);

        if (paciente == null || paciente.getDs_cep() == null || paciente.getDs_cep().isEmpty()) {
            // Se o paciente não existe ou não tem CEP, retorna nulo
            return null;
        }

        // 2. Usar o CEP do paciente para chamar a API ViaCep
        String cep = paciente.getDs_cep();
        Endereco endereco = viaCepService.getEndereco(cep);

        // 3. Retornar o objeto Endereco (do ViaCep)
        return endereco;
    }
}