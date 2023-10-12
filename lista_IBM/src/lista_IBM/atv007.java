package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv007 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//cansei da entrada válida, nova abordagem!
        try {
        	System.out.println("*********************");
            System.out.println("****** Tabuada ******");
            System.out.println("*********************\n");
            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();

            System.out.println("Tabuada do " + numero + ":");

            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                System.out.println(numero + " x " + i + " = " + resultado);
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira um número inteiro.");
        } finally {
            scanner.close();
        }
    }
	
}
