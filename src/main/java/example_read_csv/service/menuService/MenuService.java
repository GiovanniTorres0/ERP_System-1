package example_read_csv.service.menuService;

import example_read_csv.config.RetornaCSV;
import example_read_csv.modelo.Produto;

import java.util.*;


public class MenuService {


    RetornaCSV retornaCSV = new RetornaCSV();

    private List<Produto> lista = retornaCSV.RetornaCSV();
    private Queue<Produto> minhaFila = new LinkedList<Produto>();

    public List<Produto> getLista() {
        return lista;
    }


    public void buscarID() {
        boolean avancar = true;
        int id = 0;
        System.out.print("\nDigite o ID do produto: ");
        try {
            id = new Scanner(System.in).nextInt();          //guardo o que a pessoa digitou
            avancar = false;
        } catch (InputMismatchException m) {
            System.out.println("Utilize numeros!");
        }
        if (!avancar) {                                    //inicia a pesquisa se estiver tudo certo
            boolean encontrado = false;                    // variavel de controle

            for (Produto pro : lista) {                    // separo a lista por produtos
                if (pro.getId() == id) {                   // comparo o id da que a pessoa digitou com o produto por meio do getId
                    System.out.println(pro);
                    encontrado = true;
                }
            }
            if (!encontrado) {                              // retorna mensagem caso nao ache o produto
                System.out.println("Produto não Encontrado!");
            }
        }
    }


    public void retirarProduto() {
    
        boolean avancar = true;

        int id = 0;
        System.out.print("\nDigite o ID do produto: ");

            id = new Scanner(System.in).nextInt();  //guardo o que a pessoa digitou
            if(id > 2147483647) {
                throw new InputMismatchException();
            }
            avancar = false;

        if (!avancar) {                                            // inicia a pesquisa se estiver tudo certo
            boolean encontrado = false;                          // variavel de repeterole para n avançar caso o id n exista

            for (Produto fila : minhaFila) {                       // separo a FILA por produtos
                if (fila.getId() == id) {                          // comparo o id da que a pessoa digitou com o produto por meio do getId
                    encontrado = true;
                }
            }
            if (!encontrado) {                                            // retorna uma mensagem caso nao ache o produto
                System.out.println("Produto não Encontrado!");
            } else {
                int quant = 0;
                System.out.print("\nDigite a quantidade do produto: ");
                try {
                    quant = new Scanner(System.in).nextInt();               // guardo a QUANTIDADE que a pessoa digitou
                    avancar = false;
                } catch (InputMismatchException m) {
                    System.out.println("Utilize numeros!");
                }
                for (Produto fila : minhaFila) {                            // separo a fila por produtos
                    if (fila.getId() == id) {                               // comparo o id da que a pessoa digitou com o produto por meio do getId
                        if (fila.retiraitem(quant)) {               // utilizo o metodo retiraitem() pra saber se foi retirado
                            System.out.println("Produto Retitrado com Sucesso!");
                        } else {
                            boolean repete = false;
                            while (!repete) {
                                System.out.println("Deseja retirar a quantidade Disponivel: " + fila.getQuant() + " ? [SIM] ou [NAO]");     // nao conseguiu retirar pq a quant n foi suficiente        // caso entre no else é pq o metodo retornou false pois
                                String res = new Scanner(System.in).nextLine().toUpperCase(); // guardo o que a resposta

                                if (res.equals("SIM")) {
                                    fila.retiraitem(fila.getQuant());
                                    System.out.println("Produto Retitrado com Sucesso!");
                                    repete = true;
                                } else if (res.equals("NAO")) {
                                    System.out.println("Nenhuma Retitrado foi Feita!");
                                    repete = true;
                                } else {
                                    System.out.println("Digite SIM ou NAO!");
                                }
                            }

                        }
                    }
                }
            }
        }
    }
    public void filaAtt(){

        List<String> prods = new ArrayList<String>();
        for (Produto prod : minhaFila) {
            if (prod.getQuant() > 0) {
                prods.add(" " + prod.getId()); 
            }else{
                System.out.println(prod);
            }
        }
        minhaFila.clear();

        for (String i : prods) {
            int tamanho = i.length();
            int id = Integer.parseInt(i.substring(1, tamanho)); // pego o id data
            for (Produto prod : lista) {
                if (prod.getId() == id) { // acho os produtos com os mesmos ids e coloco dentro da fila
                    minhaFila.add(prod);
                }
            }
        }
    }
    public void Fila() {
        List<String> itens = new ArrayList<String>();           // lista para por as datas dos porsutos

        for (Produto prod : lista) {
            itens.add(prod.getData() + " " + prod.getId());     // coloco a data dentro da lista junto com o id
        }

        Collections.sort(itens);                                // :))) ordeno as datas da lista

        for (String i : itens) {
            int tamanho = i.length();
            int id = Integer.parseInt(i.substring(10, tamanho));    // pego o id data
            for (Produto prod : lista) {
                if (prod.getId() == id) {                           // acho os produtos com os mesmos ids e coloco dentro da fila
                    minhaFila.add(prod);
                }
            }
        }
    }
    public void buscarNome() {

        boolean avancar = false;
        System.out.print("\nDigite o Nome do produto: ");
        String nome = new Scanner(System.in).nextLine();        //guardo o que a pessoa digitou
        int i;
        for (Produto pro : lista) {                             //separo a lista por produtos
            String[] listaNome = pro.getNome().split(" ");      //divide o nome pelos espaçoes e coloca no vetor
            for (i = 0; i < listaNome.length; i++) {            //for depende de quantas partes o nome foi dividido
                if (listaNome[i].regionMatches(0, nome, 0, nome.length())) {    //compara a resposta com cada parte do nome do produto
                    System.out.println(pro);                    //imprime o produto de acordo com o toString
                    avancar = true;
                }
            }
        }
        if (!avancar) {                         //pq um if em vez de else na linha 19 ? porque cada vez que ele nao encontra ira imprimir
            System.out.println("Produto não Encontrado!");
        }
    }
    public void verificacaoBinaria(){
        int ids [] = new int[lista.size()];
        for (int i = 0 ; i < lista.size(); i++) {
            ids[i] = lista.get(i).getId();
        }
        /*
        for (int index = 0; index < ids.length; index++) {
            System.out.println(ids[index]);
        }*/
        boolean avancar = true;
        int id = 0;
        int inicio = 0 , fim = ids.length-1;
        int meio ;
        System.out.print("\nDigite o ID do produto: ");

        try {
            id = new Scanner(System.in).nextInt();         
            avancar = false;
        } catch (InputMismatchException m) {
            System.out.println("Utilize numeros!");
        }
        boolean encontrado = false;
      
        while (inicio <= fim) {
            meio = (inicio + fim ) /2;
            if(id == meio){
                System.out.println(lista.get(id));
                encontrado = true;
            }
            if(id < meio){
                fim = meio - 1;
            }else{
                inicio = meio + 1; 
            }
        } 
        if (!encontrado) {
            System.out.println("N enc");
        }
    }
    public void array(){
        int ids [] = new int[lista.size()];
        for (int i = 0 ; i < lista.size(); i++) {
            ids[i] = lista.get(i).getId();
        }
        for (int index = 0; index < ids.length; index++) {
            System.out.println(ids[index]);
        }
    }
}