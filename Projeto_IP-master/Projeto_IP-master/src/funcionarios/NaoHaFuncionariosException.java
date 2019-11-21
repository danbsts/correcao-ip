package funcionarios;


public class NaoHaFuncionariosException extends Exception {
	public NaoHaFuncionariosException() {
		super("Não Existem Funcionários Cadastrados");
	}
}
