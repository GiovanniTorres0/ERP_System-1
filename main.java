import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class main {
		 
	public static void main(String[] args) {
	
		String arquivo = "C:/Users/usuario_2.UTEC-7314/Desktop/ADS-2/Estrutura de Dados/ERP_System/Products.csv";
	
		List<produto> lista = retornaLista.Lista();
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			
			String linha = br.readLine();
			linha = br.readLine();
			for(int i = 0; i <= 10; i++){
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
		int opcao = 0;
		int id = 0;
		boolean avancar = false;
		while (opcao != 3) {
			System.out.println("\n1 - Buscar produto por código");
			System.out.println("2 - Buscar produto por nome");
			System.out.println("3- Sair");
			System.out.print("Opção: ");
			try{
				opcao = new Scanner(System.in).nextInt();
			}
			catch(InputMismatchException m){
				System.out.println("Utilize numeros!");
			}
			switch (opcao) {
				case 1:
				System.out.print("\nDigite o ID do produto: ");
				id = new Scanner(System.in).nextInt();
				 
					for (produto pro : lista) {
						if(pro.getId() == id){
							System.out.println(pro);
							avancar = true;
						}
					}
					if(avancar == false){
							System.out.println("Produto não Encontrado!");
					}

					break;
					
				case 2:
					break;

				case 3:

					System.out.print("Aplicativo Encerrado.");
					break;
					default:
					System.out.println("Opçao Invalida");
					break;
			}
		}
		
		
	}
}