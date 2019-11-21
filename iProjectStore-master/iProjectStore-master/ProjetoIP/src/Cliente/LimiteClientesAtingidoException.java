package Cliente;

public class LimiteClientesAtingidoException extends Exception{
	public LimiteClientesAtingidoException() {
		super("O limite de clientes cadastrados foi atingido.");
	}
}
