package Exceptions;

public class GadoNaoExisteException extends Exception {
	public GadoNaoExisteException() {
		super("Gado não encontrado!");
	}
}