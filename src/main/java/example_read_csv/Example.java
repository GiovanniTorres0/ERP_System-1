package example_read_csv;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        if (retornaLista.Lista().isEmpty()) { 	// carrega as info na lista caso contrario nao funciona
            System.out.println("Lista Vazia");
        } else {
            System.out.println("\tBem vindo ao Gerenciador de Produtos Eletronicos");
            int opcao = 0;
            while (opcao != 3) {
                System.out.println("\n1 - Buscar produto por código");
                System.out.println("2 - Buscar produto por nome");
                System.out.println("3- Sair");
                System.out.print("Opção: ");
                try {
                    opcao = new Scanner(System.in).nextInt();
                } catch (InputMismatchException m) {
                    System.out.println("Utilize numeros!");
                }
                switch (opcao) {
                    case 1:
                        buscaPorId.ID();
                        break;

                    case 2:
                        buscaPorNome.Nome();
                        break;

                    case 3:
                        System.out.print("Aplicativo Encerrado.");
                        break;
                    default:
                        System.out.println("Opçao Invalida");
                        break;
                }
            }
        }
    }
}




