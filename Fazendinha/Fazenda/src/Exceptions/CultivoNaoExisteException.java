package Exceptions;

public class CultivoNaoExisteException extends Exception{
	public CultivoNaoExisteException() {
		super("Cultivo n�o existe");
	}
}
