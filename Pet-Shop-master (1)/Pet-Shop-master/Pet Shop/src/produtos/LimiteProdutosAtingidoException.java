package produtos;

public class LimiteProdutosAtingidoException extends Exception {
	public LimiteProdutosAtingidoException () {
		super ("Limite de Estoque Atingido");
	}

}
