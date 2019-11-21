package Exceptions;

public class InsumoJaCadastradoException extends Exception {
	public InsumoJaCadastradoException() {
		super("Esse insumo já está cadastrado");
	}
}