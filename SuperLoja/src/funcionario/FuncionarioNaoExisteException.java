package funcionario;

public class FuncionarioNaoExisteException extends Exception {
	public FuncionarioNaoExisteException() {
		super("O funcionário não existe");
	}
}
