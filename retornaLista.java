import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class retornaLista {
    public static List<produto> Lista() {
		List<produto> lista = new ArrayList<produto>();
		String arquivo = "C:/Users/usuario_2.UTEC-7314/Desktop/ERP/ERP_System/Products.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			for(int i = 0; i <= 10; i++){	//alterar
				String[] vect = linha.split(",");		 //separo o arquivo pelas virgulas colocando em vetor
				int id = Integer.parseInt(vect[0]);
				Double preço = Double.parseDouble(vect[2]);
				String nome = vect[21];
				produto prod = new produto(id, preço, nome);
				lista.add(prod); 		//cria um produto com os dados do vetor e coloco na lista
				
				linha = br.readLine();
			}	
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
			return lista;

		}
}
