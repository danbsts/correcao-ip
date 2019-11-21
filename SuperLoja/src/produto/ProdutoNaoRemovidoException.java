package produto;

public class ProdutoNaoRemovidoException extends Exception {
	ProdutoNaoRemovidoException() {
		super("Não foi possível remover o produto.");
	}

}
