package lista_IBM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class atv001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.println("********************************");
                System.out.println("***** Soma de Dois Numeros *****");
                System.out.println("********************************\n");

                System.out.print("Digite o primeiro numero: ");
                double numero1 = sc.nextDouble();

                System.out.print("Digite o segundo numero: ");
                double numero2 = sc.nextDouble();

                double soma = numero1 + numero2;

                System.out.printf("O resultado da soma é: %.2f\n", soma);
                entradaValida = true; 
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um numero válido.");
                sc.next();
            }
        }

        sc.close();
    }
}
