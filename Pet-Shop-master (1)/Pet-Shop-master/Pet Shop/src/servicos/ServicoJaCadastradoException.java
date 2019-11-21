package servicos;

public class ServicoJaCadastradoException extends Exception {
	public ServicoJaCadastradoException () {
		super ("Servico ja cadastrado");
	}
}
