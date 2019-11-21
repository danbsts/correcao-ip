package vendas;

public class ExisteVendaException extends Exception{
	public ExisteVendaException() {
		super("Essa venda ja foi efetivada");
		}
}
