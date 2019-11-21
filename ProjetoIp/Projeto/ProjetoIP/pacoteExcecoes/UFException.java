package pacoteExcecoes;

public class UFException extends Exception {
	public UFException() {
		super("Este documento já existe no sistema, favor tentar novamente.");
	}
}
