
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class buscaPorId {
    public static void ID() {
        List<produto> lista = retornaLista.Lista();         //crio a lista a partir da lista dos produtos
        boolean avancar = true;
        int id = 0 ;
        System.out.print("\nDigite o ID do produto: ");
        try {
            id = new Scanner(System.in).nextInt();          //guardo o que a pessoa digitou
            avancar = false;
        } catch (InputMismatchException m) {
            System.out.println("Utilize numeros!");
        }
        if (!avancar) {                                    //inicia a pesquisa se estiver tudo certo
            boolean encontrado = false;                    // variavel de controle

            for (produto pro : lista) {                    // separo a lista por produtos
                if (pro.getId() == id) {                   // comparo o id da que a pessoa digitou com o produto por meio do getId
                    System.out.println(pro);
                    encontrado = true;
                }
            }
            if (encontrado == false) {                     // retorna mensagem caso nao ache o produto
                System.out.println("Produto não Encontrado!");
            }
        }
		
    }
}
