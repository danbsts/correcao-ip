package vendas;

public class NaoExisteException extends Exception{
	public NaoExisteException() {
		super("Essa venda ainda nao foi efetivada");
		}
}
