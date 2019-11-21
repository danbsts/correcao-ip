package ingredientes;
public class Ingrediente {
	private String nome;
	private int qtd;
	private double preco;
	private String identificador;

	public Ingrediente(String nome, int qtd, double preco, String identificador) {
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
		this.identificador = identificador;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return this.qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getIdentificador() {
		return this.identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}