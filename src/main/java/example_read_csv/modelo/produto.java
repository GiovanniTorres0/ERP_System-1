package example_read_csv.modelo;

public class produto{
//teste
	private int id;											//atributos do mesmo tipo que o dados do .csv
	private Double preço;
	private String nome;
	private int quant;
	private String data;

	public produto(int id, Double preço,String nome,String data) {		//construtor facilita a criaçao com a passagem dos dados
		super();
		this.id = id;
		this.preço = preço;
		this.data = data;
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
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
	
	public boolean retiraitem(int valor) {
        boolean avancar;
        if (this.quant >= valor) {
            this.quant = this.quant - valor;
            avancar = true;
        } else {
            avancar = false;
        }
        return avancar;
    }

	@Override
	public String toString() {
		return "\nProduto Id: " + id + ", Preço: " + preço+", Quantidade: "+quant+", Data: "+data+", Nome: " + nome ;		//manda os dados arrumados para ser usado no foreach
	}
}