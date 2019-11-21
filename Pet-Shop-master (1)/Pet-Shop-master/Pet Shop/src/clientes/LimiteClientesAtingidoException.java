package clientes;

public class LimiteClientesAtingidoException extends Exception{
	public LimiteClientesAtingidoException () {
		super ("Limite de clientes cadastrados atingido!");
	}
}
