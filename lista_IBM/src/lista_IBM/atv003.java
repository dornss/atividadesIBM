package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv003 {
	
	private static String sair = "s";

    static double calcular(double num1, double num2, String operacao) {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                    return num1;
                }
            default:
                System.out.println("Erro: Operação inválida.");
                return num1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado = 0;
        boolean primeiraOperacao = true;

        System.out.println("*********************************");
        System.out.println("****** Calculadora Simples ******");
        System.out.println("**********************************\n");
        System.out.println("Digite 's' para sair.");

        boolean continuar = true;
        while (continuar) {
            try {
                if (primeiraOperacao) {
                    System.out.print("Digite o primeiro número: ");
                    resultado = scanner.nextDouble();
                    primeiraOperacao = false;
                }

                System.out.print("Digite a operação (+, -, *, /) ou 's' para sair: ");
                String operacao = scanner.next();

                if (sair.equals(operacao)) {
                    continuar = false;
                } else {
                    System.out.print("Digite o próximo número: ");
                    double numero = scanner.nextDouble();

                    resultado = calcular(resultado, numero, operacao);
                    System.out.println("Resultado: " + resultado);
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
                scanner.next();
            }
        }
        
        System.out.println("Calculadora encerrada.");
        scanner.close();

    }
}