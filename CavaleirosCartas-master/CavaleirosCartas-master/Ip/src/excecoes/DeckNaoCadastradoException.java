package excecoes;

public class DeckNaoCadastradoException extends Exception{
	public DeckNaoCadastradoException() {

		super("O deck do duelista não foi cadastrado");

	}
}
