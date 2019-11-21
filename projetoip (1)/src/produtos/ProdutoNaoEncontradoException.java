package produtos;
public class ProdutoNaoEncontradoException extends Exception {

	private String nome;

	//Erro para caso tente interagir com um produto que nao exista
	public ProdutoNaoEncontradoException(String nome) {

		super ("Produto nao encontrado");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
