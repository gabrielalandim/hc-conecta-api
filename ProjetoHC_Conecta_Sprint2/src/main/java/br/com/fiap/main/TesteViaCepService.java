package br.com.fiap.main;

import br.com.fiap.api.Endereco;
import br.com.fiap.services.ViaCepService;

import javax.swing.JOptionPane;
import java.io.IOException;

public class TesteViaCepService {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws IOException {

        ViaCepService objViaCep = new ViaCepService();
        String cep = texto("Informe o CEP para a busca");

        Endereco endereco = objViaCep.getEndereco(cep);

        if (endereco != null && endereco.getCep() != null) {
            System.out.println("--- ENDEREÇO ENCONTRADO ---");
            System.out.println(endereco);
        } else {
            System.out.println("CEP não encontrado ou inválido.");
        }
    }
}