package funcionarios;

public class FuncionarioJaCadastradoException extends Exception {
	
	public FuncionarioJaCadastradoException() {
		super ("Este funcionario ja esta cadastrado no sistema.");
	}
}
