import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class retornaLista {
    public static List<produto> Lista() {
		List<produto> lista = new ArrayList<produto>();
		 //testes de pra ver se fica acessivel em todas as class
		String arquivo = "C:/csv/Products.csv"; 

		try (BufferedReader buf = new BufferedReader(new FileReader(arquivo))) { 	//leitura mais otimizada | FileReader classe de leitura de dados  | BufferedReader gerencia a memoria usada para a leitura
			String linha = buf.readLine();								//readLine le a linha do arquivo e retorna uma String
			linha = buf.readLine(); 									//pula a primeria linha que é cabeçalho
			for(int i = 0; i <= 10; i++){								//alterar o tamanho e muda pra while(linha != null){ se nao tiver mais linhas pra ler ele retorna nulo
				String[]produtos = linha.split(",");					//le a linha separando o arquivo pelas virgulas e colocando no vetor
				int id = Integer.parseInt(produtos[0]);
				Double preço = Double.parseDouble(produtos[2]);
				String nome = produtos[21];
				
				String data = produtos[14].substring(0, 10).trim();          //F5 
				produto prod = new produto(id, preço, nome, data); 			//passa como parementro as info do vetor instanciando o produto
				int quant = (int)( Math.random()*98)+1;						//F5
				prod.setQuant(quant);										//F5
				
				lista.add(prod); 										//preenche a lista com o produto
				
				linha = buf.readLine();									//le a proxima linha do arquivo
			}	
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
			return lista;		//lista diponivel para usar de qualquer lugar
	}

}
