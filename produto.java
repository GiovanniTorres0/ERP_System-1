public class produto{

	private int id;											//atributos do mesmo tipo que o dados do .csv;
	private Double preço;
	private String nome;

	public produto(int id, Double preço,String nome) {		//construtor facilita a criaçao com a passagem dos dados
		super();
		this.id = id;
		this.preço = preço;
		this.nome = nome;
	}

	public String getNome() {								//retorna o nome para ser utilizado em funcionalidades
		return nome;
	}

	public int getId() {									//retorna o ID para ser utilizado em funcionalidades
		return id;
	}

	public Double getPreço() {								//retorna o preço para ser utilizado em funcionalidades
		return preço;
	}

	@Override
	public String toString() {
		return "\nProduto Id: " + id + ", Preço: " + preço+ ", Nome: " + nome ;		//manda os dados arrumados para ser usado no foreach
	}
}
