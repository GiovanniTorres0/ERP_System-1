
import java.util.List;
import java.util.Scanner;

public class buscaPorId {
    public static void ID() {
        List<produto> lista = retornaLista.Lista();
        
		boolean avancar = false;
        int id = 0;
        System.out.print("\nDigite o ID do produto: ");
        id = new Scanner(System.in).nextInt();

        for (produto pro : lista) {
            if (pro.getId() == id) {
                System.out.println(pro);
                avancar = true;
            }
        }
        if (avancar == false) {
            System.out.println("Produto não Encontrado!");
        }
    }
}
