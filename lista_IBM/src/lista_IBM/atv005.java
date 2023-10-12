package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;
        
        System.out.println("*********************************");
        System.out.println("****** Contagem Regressiva ******");
        System.out.println("**********************************\n");
        
		while(!entradaValida) {			
			try {
				
				System.out.println("Digite um número");
				int numero = sc.nextInt();
				
				System.out.println("PREPARE-SE PARA DECOLAR!");
				while(numero >=0) {
					System.out.printf("Contagem regressiva: %d\n", numero);
					numero--;
				}
				System.out.println("JA!!!!!!!!!!!!");
				entradaValida = true;
				
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
				sc.next();
			}
		}
		sc.close();
	}
}
