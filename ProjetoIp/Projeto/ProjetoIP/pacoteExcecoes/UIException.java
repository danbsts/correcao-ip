package pacoteExcecoes;

public class UIException extends Exception {
	public UIException() {
		super("Pessoa não cadastrada no sistema. Escolha a opção de Cadastrar Pessoa em nosso site.");
	}

}
