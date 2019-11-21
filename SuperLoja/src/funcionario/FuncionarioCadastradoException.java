package funcionario;

//extends e quando herda
public class FuncionarioCadastradoException extends Exception {

	public FuncionarioCadastradoException() {
		super("Funcionário já cadastrado");
	}

}
