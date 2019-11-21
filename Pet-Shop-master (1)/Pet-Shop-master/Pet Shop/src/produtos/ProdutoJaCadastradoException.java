package produtos;

public class ProdutoJaCadastradoException extends Exception {
	public ProdutoJaCadastradoException () {
		super ("Produto ja foi cadastrado anteriormente.");
	}
}
