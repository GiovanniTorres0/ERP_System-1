import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class retornaLista {
    public static List<produto> Lista() {
		List<produto> lista = new ArrayList<produto>();
		String arquivo = "C:/Users/usuario_2.UTEC-7314/Desktop/ERP/Products.csv";

		try (BufferedReader buf = new BufferedReader(new FileReader(arquivo))) {
			String linha = buf.readLine();
			linha = buf.readLine();
			for(int i = 0; i <= 100; i++){	//alterar o tamanho
				String[]produtos = linha.split(",");		 //separo o arquivo pelas virgulas colocando em vetor
				int id = Integer.parseInt(produtos[0]);
				Double preço = Double.parseDouble(produtos[2]);
				String nome =produtos[21];
				produto prod = new produto(id, preço, nome); //passa como parementro as info do vetor pra classe
				lista.add(prod); 		//cria um produto com os dados do vetor e coloco na lista
				
				linha = buf.readLine();
			}	
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
			return lista;
	}
}
