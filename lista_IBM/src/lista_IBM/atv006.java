package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv006 {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int contador = 0;

        try {
        	
        	System.out.println("*******************************");
            System.out.println("****** Média de vários n ******");
            System.out.println("*********************************\n");
            System.out.println("Digite uma série de números para calcular a média.");
            System.out.println("Digite 's' para calcular a média e sair.");

            String entrada;
            while (true) {
                System.out.print("Digite um número ou 's' para sair: ");
                entrada = scanner.next();

                if (entrada.equalsIgnoreCase("s")) {
                    break; 
                }

                double numero = Double.parseDouble(entrada);
                soma += numero;
                contador++;
            }

            if (contador > 0) {
                double media = soma / contador;
                System.out.println("Média dos números inseridos: " + media);
            } else {
                System.out.println("Nenhum número válido inserido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um número ou 's' para sair.");
        } finally {
            scanner.close();
        }
    }

}
