package funcionarios;

public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException() {
		super("Funcionário Já Cadastrado");
	}
}

