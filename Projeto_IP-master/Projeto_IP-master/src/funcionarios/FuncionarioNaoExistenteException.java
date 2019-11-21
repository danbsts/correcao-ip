package funcionarios;

public class FuncionarioNaoExistenteException extends Exception {
	public FuncionarioNaoExistenteException() {
		super("Funcionário Não Cadastrado");
	}
}
