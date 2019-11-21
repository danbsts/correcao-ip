package produto;

public class Produto {
	private String nome_Produto;
	private double valor;
	private int quantidade;
	private double valor_de_Compra;
	private double valor_de_Venda;

	public Produto(String nome, double valor, int quantidade, double valordecompra, double valordevenda) {
		this.nome_Produto = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.valor_de_Compra = valordecompra;
		this.valor_de_Venda = valordevenda;
	}

	public String getNome_Produto() {
		return nome_Produto;
	}

	public void setNome_Produto(String nome_Produto) {
		this.nome_Produto = nome_Produto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_de_Compra() {
		return valor_de_Compra;
	}

	public void setValor_de_Compra(double valor_de_Compra) {
		this.valor_de_Compra = valor_de_Compra;
	}

	public double getValor_de_venda() {
		return valor_de_Venda;
	}

	public void setValor_de_venda(double valor_de_venda) {
		this.valor_de_Venda = valor_de_venda;
	}

	public boolean equalsProduto(String nomedoproduto) {
		if (this.nome_Produto == nomedoproduto) {
			return true;
		} else {
			return false;
		}
	}

}
