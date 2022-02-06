
import java.util.List;
import java.util.Scanner;
public class buscaPorNome {
    public static void Nome() {
        List<produto> lista = retornaLista.Lista();

        boolean avancar = false;

        System.out.print("\nDigite o Nome do produto: ");
        String nome = new Scanner(System.in).nextLine();

        for (produto pro : lista) {
            String[] listaNome = pro.getNome().split(" ");      // divide o nome no vetor
            for (int j = 0; j < listaNome.length; j++) {
                if (listaNome[j].regionMatches(0, nome, 0, nome.length())) {    //pesquisa em cada parte do nome do produto 
                    System.out.println(pro);
                    avancar = true;
                }
            }
        }
        if (avancar == false) {
            System.out.println("Produto não Encontrado!");
        }
    }
}
