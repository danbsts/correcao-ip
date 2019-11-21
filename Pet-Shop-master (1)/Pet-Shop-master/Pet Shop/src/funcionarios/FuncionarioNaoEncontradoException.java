package funcionarios;

public class FuncionarioNaoEncontradoException extends Exception{
	public FuncionarioNaoEncontradoException() {
		super("Desculpe, este funcionario nao foi encontrado no sistema");
	}
}
