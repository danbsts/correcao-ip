package produto;

public class ProdutoNaoEncontradoException extends Exception {
	ProdutoNaoEncontradoException() {
		super("O produto n�o foi encontrado.");
	}

}
