package funcionario;
public class FuncionarioJaCadastradoException extends Exception {
	public FuncionarioJaCadastradoException() {
		super("Funcionario ja cadastrado!");
	}
}