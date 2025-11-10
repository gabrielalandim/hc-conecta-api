package br.com.fiap.main;

import javax.swing.JOptionPane;

public class TesteExcecao {

    public static void main(String[] args) {

        // 1. Criamos uma "flag" para saber se deu certo
        boolean sucesso = false;

        try {
            // Tenta ler a entrada do usuário
            String input = JOptionPane.showInputDialog("Digite o valor (ex: 123.45)");

            if (input == null) {
                // Usuário clicou em "Cancelar" ou fechou a janela
                System.out.println("Operação cancelada pelo usuário.");

            } else {
                // Tenta converter o texto em número
                double valor = Double.parseDouble(input);

                // Se chegou aqui, deu certo!
                System.out.println("Valor digitado: " + valor);
                sucesso = true; // 2. Marcamos a flag como SUCESSO
            }

        } catch (NumberFormatException e) {
            // Captura o erro se o usuário digitar letras (ex: "ABC")
            System.out.println("ERRO: O valor digitado não é um número válido.");
            // e.printStackTrace(); // Opcional: para debugar

        } catch (Exception e) {
            // Captura qualquer outro erro inesperado
            System.out.println("ERRO: Ocorreu uma falha desconhecida.");
            e.printStackTrace();

        } finally {
            // 3. O 'finally' agora lê a flag e dá uma mensagem clara
            System.out.println("--- Verificação Final ---");
            if (sucesso) {
                System.out.println("Status: Operação realizada com SUCESSO.");
            } else {
                System.out.println("Status: Operação FALHOU ou foi cancelada.");
            }
            System.out.println("--- Fim do teste de exceção ---");
        }
    }
}
