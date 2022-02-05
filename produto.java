
import java.io.Serializable;

public class produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private Double preço;
	private String nome;

	public produto() {
	}

	public produto(int id, Double preço,String nome) {
		super();
		this.id = id;
		this.preço = preço;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public Double getPreço() {
		return preço;
	}

	@Override
	public String toString() {
		return "\nProduto Id: " + id + ", Preço: " + preço+ ", Nome: " + nome ;
	}
}