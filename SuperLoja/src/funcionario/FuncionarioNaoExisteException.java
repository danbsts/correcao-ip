package funcionario;

public class FuncionarioNaoExisteException extends Exception {
	public FuncionarioNaoExisteException() {
		super("O funcion�rio n�o existe");
	}
}
