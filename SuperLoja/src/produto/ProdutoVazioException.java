package produto;

public class ProdutoVazioException extends Exception {
	public ProdutoVazioException() {
		super("Produto acessado est� vazio.");
	}

}
