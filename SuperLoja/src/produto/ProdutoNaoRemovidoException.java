package produto;

public class ProdutoNaoRemovidoException extends Exception {
	ProdutoNaoRemovidoException() {
		super("N�o foi poss�vel remover o produto.");
	}

}
