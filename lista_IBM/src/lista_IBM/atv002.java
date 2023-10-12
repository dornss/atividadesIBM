package lista_IBM;

import java.util.Scanner;

public class atv002 {

	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);
	try {
        System.out.println("********************************");
        System.out.println("*** Verificador Par ou Impar ***");
        System.out.println("********************************\n");

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        String resultado = (numero % 2 == 0) ? "PAR" : "IMPAR";
        System.out.printf("%d é um número %s", numero, resultado);
    } catch (java.util.InputMismatchException e) {
        System.out.println("Erro: Por favor, insira um número inteiro.");
    } finally {
        scanner.close();
    }
}
}
