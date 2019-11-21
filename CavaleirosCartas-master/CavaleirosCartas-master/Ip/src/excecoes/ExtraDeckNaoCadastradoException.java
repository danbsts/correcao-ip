package excecoes;

public class ExtraDeckNaoCadastradoException extends Exception{
	public ExtraDeckNaoCadastradoException() {

		super("O extra-deck do duelista não foi cadastrado");

	}
}
