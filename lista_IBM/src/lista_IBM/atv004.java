package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv004 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;
        int numero = 0;

        while (!entradaValida) {
            try {
            	System.out.println("**********************************");
                System.out.println("****** Calculadora Fatorial ******");
                System.out.println("***********************************\n");
                System.out.print("Digite um número para calcular o fatorial: ");
                numero = sc.nextInt();

                if (numero < 0) {
                    System.out.println("Erro: Por favor, insira um número não negativo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número inteiro.");
                sc.next(); 
            }
        }

        float fatorial = calcularFatorial(numero);
        System.out.println("O fatorial de " + numero + " eh: " + fatorial);

        sc.close();
    }
   

    static float calcularFatorial(int numero) {
    	if (numero == 0 || numero == 1) {
            return 1	;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}
