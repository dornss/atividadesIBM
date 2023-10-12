package lista_IBM;

import java.util.Scanner;

public class atv008 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        String opposite = "";
        System.out.println("************************");
        System.out.println("****** Palíndromo ******");
        System.out.println("************************\n");
        System.out.println("Digite uma palavra para verificar se é um palíndromo");
        String nome = sc.nextLine();

        
        for (int i = (nome.length() -1); i >= 0; i--) {
            opposite = opposite + nome.charAt(i);
        }
        
        
        if (opposite.toLowerCase().equals(nome.toLowerCase())) {
            System.out.println("Essa palavra é um palíndromo");
        } else {
            System.out.println("Essa palavra não é um palíndromo");
        }
        
        sc.close();
	 }
}
