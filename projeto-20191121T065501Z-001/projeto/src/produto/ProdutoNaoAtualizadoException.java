package produto;

public class ProdutoNaoAtualizadoException extends Exception {
	ProdutoNaoAtualizadoException() {
		super("O Produto n�o foi atualizado");
	}
}
