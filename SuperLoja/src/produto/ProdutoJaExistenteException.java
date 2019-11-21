package produto;

public class ProdutoJaExistenteException extends Exception {
	ProdutoJaExistenteException() {
		super("Este produto já existe.");
	}

}
