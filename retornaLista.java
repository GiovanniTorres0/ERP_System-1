import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class retornaLista {
    public static List<Product> Lista() {
		List<Product> lista = new ArrayList<Product>();
		String arquivo = "C:/Users/usuario_2.UTEC-7314/Desktop/ADS-2/Estrutura de Dados/ERP_System/Products.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			for(int i = 0; i <= 10; i++){
				String[] vect = linha.split(",");		 //separo o arquivo pelas virgulas colocando em vetor
				int id = Integer.parseInt(vect[0]);
				Double preço = Double.parseDouble(vect[2]);
				String nome = vect[21];
				Product prod = new Product(id, preço, nome);
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
