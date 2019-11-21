package funcionario;
public class FuncionarioInexistenteException extends Exception {
public FuncionarioInexistenteException() {
	super("cpf não encontrado");
}
}
