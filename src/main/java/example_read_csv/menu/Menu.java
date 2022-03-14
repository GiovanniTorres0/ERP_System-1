package example_read_csv.menu;

import example_read_csv.service.menuServiceImp.MenuService;

import java.util.Scanner;

public class Menu {

    MenuService menuService = new MenuService();

    Scanner ler = new Scanner(System.in);

    public void menu() {
        menuService.Fila();

        if (menuService.getLista().isEmpty()) {    // carrega as info na lista caso contrario nao funciona
            System.out.println("Lista Vazia");
        } else {
            System.out.println("\tBem vindo ao Gerenciador de Produtos Eletronicos");

            System.out.println("\n1 - Buscar produto por código");
            System.out.println("2 - Buscar produto por nome");
            System.out.println("3 - Buscar produto por nome");
            System.out.println("4- Sair");
            System.out.print("Opção: ");
            int opcao = ler.nextInt();

            do {



                switch (opcao) {
                    case 1:
                        menuService.buscarID();
                        break;
                    case 2:
                        menuService.buscarNome();
                        break;
                    case 3:
                        menuService.retirarProduto();
                        break;
                    case 4:
                        break;
                    default:
                        break;

                }

                System.out.println("\n1 - Buscar produto por código");
                System.out.println("2 - Buscar produto por nome");
                System.out.println("3 - Buscar produto por nome");
                System.out.println("4- Sair");
                System.out.print("Opção: ");
                opcao = ler.nextInt();

            } while (opcao != 9);


        }
    }
}