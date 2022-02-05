
import java.util.List;
import java.util.Scanner;
public class buscaPorNome {
    public static void Nome() {
        List<produto> lista = retornaLista.Lista();
        
		boolean avancar = false;

        System.out.print("\nDigite o Nome do produto: ");
        String nome = new Scanner(System.in).nextLine();

        for (produto pro : lista) {
            if (pro.getNome().regionMatches( 0 , nome, 0 , nome.length()))  {
                System.out.println(pro);
                avancar = true;
            }
        }
        if (avancar == false) {
            System.out.println("Produto não Encontrado!");
        }
    }
}
