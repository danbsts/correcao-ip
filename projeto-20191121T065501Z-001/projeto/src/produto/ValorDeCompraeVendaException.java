package produto;

public class ValorDeCompraeVendaException extends Exception {
	public ValorDeCompraeVendaException() {
		super("Valor de compra ou venda inválidos");
	}
}
