package pacoteExcecoes;

public class RNCException extends Exception {
	public RNCException() {
		super("Reserva não cadastrada. Tente novamente");
	}
}
