
import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private Double preço;
	private String nome;

	public Product() {
	}

	public Product(int id, Double preço,String nome) {
		super();
		this.id = id;
		this.preço = preço;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public Double getPreço() {
		return preço;
	}

	@Override
	public String toString() {
		return "\nProduct Id: " + id + ", Preço: " + preço+ ", Nome: " + nome ;
	}
}