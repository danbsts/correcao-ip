package servicos;

public class ServicoNaoEncontradoException extends Exception {			
	public ServicoNaoEncontradoException () {
		super ("Servico nao encontrado");
	}
}
