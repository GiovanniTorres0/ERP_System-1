
import java.util.List;
import java.util.Scanner;
public class buscaPorNome {
    public static void Nome() {
        List<produto> lista = retornaLista.Lista();             //crio a lista a partir da lista dos produtos

        boolean avancar = false;
        System.out.print("\nDigite o Nome do produto: ");
        String nome = new Scanner(System.in).nextLine();        //guardo o que a pessoa digitou
        int i ;
        for (produto pro : lista) {                             //separo a lista por produtos
            String[] listaNome = pro.getNome().split(" ");      //divide o nome pelos espaçoes e coloca no vetor
            for (i = 0; i < listaNome.length; i++) {            //for depende de quantas partes o nome foi dividido
                if (listaNome[i].regionMatches(0, nome, 0, nome.length())) {    //compara a resposta com cada parte do nome do produto
                    System.out.println(pro);                    //imprime o produto de acordo com o toString
                    avancar = true;
                }
            }
        }
        if (!avancar ) {                                 //pq um if em vez de else na linha 19 ? porque cada vez que ele nao encontra ira imprimir
            System.out.println("Produto não Encontrado!");
        }
    }
}
