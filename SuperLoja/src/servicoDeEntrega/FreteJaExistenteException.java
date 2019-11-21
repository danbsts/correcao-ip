package servicoDeEntrega;

public class FreteJaExistenteException extends Exception {
	public FreteJaExistenteException() {
		super("O frete ja foi computado!");
	}
}
