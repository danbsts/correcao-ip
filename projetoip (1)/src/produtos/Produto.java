package produtos;

public class Produto {
	//Definiros identificadors, gerar os get's e set's, e construtor(es).

	private String nome;
	private String descricao;
	private double valor;

	public Produto (String nome, String descricao, double valor) {

		this.nome = nome;
		this.descricao = descricao;

		if(valor > 0) {
			this.valor = valor;
		}
		else {

		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


}
