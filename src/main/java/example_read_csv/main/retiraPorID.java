package example_read_csv.main;

import example_read_csv.modelo.produto;
import example_read_csv.metodos.retornaLista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class retiraPorID {

    public static void main(String[] args) {

        Queue<produto> minhaFila = new LinkedList<produto>();
        List<produto> lista = retornaLista.Lista();

        List<String> itens = new ArrayList<String>();           // lista para por as datas dos porsutos

        for (produto prod : lista) {
            itens.add(prod.getData()+" "+ prod.getId());     // coloco a data dentro da lista junto com o id
        }

        Collections.sort(itens);                                // :))) ordeno as datas da lista

        for (String i : itens) {
            int tamanho = i.length();
            int id = Integer.parseInt(i.substring(10, tamanho));    // pego o id data
            for (produto prod : lista) {
                if (prod.getId() == id) {                           // acho os produtos com os mesmos ids e coloco dentro da fila
                    minhaFila.add(prod);
                }
            }
            System.out.println(id);                                 // mostro pra ter certeza dos ids
        }

        for (produto fila : minhaFila) {                            // mostro a fila pra saber de qual id tirar
            System.out.println(fila);
        }

        boolean avancar = true;
        int id = 0;

        System.out.print("\nDigite o ID do produto: ");
        try {
            id = new Scanner(System.in).nextInt();                  // guardo o ID que a pessoa digitou
            avancar = false;
        } catch (InputMismatchException m) {
            System.out.println("Utilize numeros!");
        }

        if (!avancar) {                                            // inicia a pesquisa se estiver tudo certo
            boolean enrepeterado = false;                          // variavel de repeterole para n avançar caso o id n exista

            for (produto fila : minhaFila) {                       // separo a FILA por produtos
                if (fila.getId() == id) {                          // comparo o id da que a pessoa digitou com o produto por meio do getId
                    enrepeterado = true;
                }
            }
            if (!enrepeterado) {                                            // retorna uma mensagem caso nao ache o produto
                System.out.println("Produto não Enrepeterado!");
            } else {
                int quant = 0;
                System.out.print("\nDigite a quantidade do produto: ");
                try {
                    quant = new Scanner(System.in).nextInt();               // guardo a QUANTIDADE que a pessoa digitou
                    avancar = false;
                } catch (InputMismatchException m) {
                    System.out.println("Utilize numeros!");
                }
                for (produto fila : minhaFila) {                            // separo a fila por produtos
                    if (fila.getId() == id) {                               // comparo o id da que a pessoa digitou com o produto por meio do getId
                        if (fila.retiraitem(quant) == true) {               // utilizo o metodo retiraitem() pra saber se foi retirado
                            System.out.println("Produto Retitrado com Sucesso!");
                        } else {
                            boolean repete = false;
                            while (!repete) {
                                System.out.println("Deseja retirar a quantidade Disponivel: " + fila.getQuant()+ " ? [SIM] ou [NAO]");     // nao conseguiu retirar pq a quant n foi suficiente        // caso entre no else é pq o metodo retornou false pois
                                String res = new Scanner(System.in).nextLine(); // guardo o que a resposta

                                if (res.equals("SIM")) {
                                    fila.retiraitem(fila.getQuant());
                                    System.out.println("Produto Retitrado com Sucesso!");
                                    repete = true;
                                } else if (res.equals("NAO")) {
                                    System.out.println("Nenhuma Retitrado foi Feita!");
                                    repete = true;
                                }else{
                                    System.out.println("Digite SIM ou NAO!");
                                }
                            }

                        }
                    }
                }
            }
        }

        for (produto prod : lista) {
            if (prod.getQuant() == 0 && prod.getId() == id) {
                minhaFila.remove();
            } 
        }
        //remover o produto apenas so da fila e so se o a quantidade for 0
        
        for (produto fila : minhaFila) { // separo a FILA por produtos
            System.out.println(fila);
        } 
       
        /*
         * for (int index = 0; index < minhaFila.size(); index++) {
         * if(((produto) minhaFila).getQuant() == 0){
         * minhaFila.remove();
         * }
         * }
         * for (produto fila : lista) {
         * if(fila.getQuant() == 0){
         * lista.remove(id-1);
         * break;
         * }
         */
    }
}
