package example_read_csv.menu;

import java.util.Scanner;

import example_read_csv.service.menuService.MenuService;

public class Menu {

    MenuService menuService = new MenuService();

    Scanner ler = new Scanner(System.in);

    public void menu() {
        int opcao =0;
        menuService.Fila();
        if (menuService.getLista().isEmpty()) {    // carrega as info na lista caso contrario nao funciona
            System.out.println("Lista Vazia");
        } else {
            
            System.out.println("\tBem vindo ao Gerenciador de Produtos Eletronicos");

            do {
                System.out.println("\n1 - Buscar produto por código");
                System.out.println("2 - Buscar produto por nome");
                System.out.println("3 - Retirar Produtos por Código.");
                System.out.println("4- Sair");
                System.out.print("Opção: ");
                opcao = ler.nextInt();


                switch (opcao) {
                    case 1:
                        menuService.buscarID();
                        break;
                    case 2:
                        menuService.buscarNome();
                        break;
                    case 3:
                        menuService.retirarProduto();
                        menuService.filaAtt();
                        break;
                    case 4:
                    
                        break;
                    default:
                        break;

                }

            } while (opcao != 9);


        }
    }
}