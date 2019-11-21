package excecoes;

public class IdJaCadastradoException extends Exception {
	public IdJaCadastradoException() {

		super("Esse ID já está cadastrado");

	}
}
