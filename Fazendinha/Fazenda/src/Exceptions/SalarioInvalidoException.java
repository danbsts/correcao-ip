package Exceptions;

public class SalarioInvalidoException extends Exception {
	public SalarioInvalidoException() {
		super("Salario só assume valores positivos");
	}

}
