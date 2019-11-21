package pacoteExcecoes;

public class NOException extends Exception {
	public NOException() {
		super("Não existe repositório para esta opção.");
	}

}
