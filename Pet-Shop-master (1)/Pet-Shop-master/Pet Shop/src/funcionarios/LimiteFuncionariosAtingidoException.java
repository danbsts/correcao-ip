package funcionarios;

public class LimiteFuncionariosAtingidoException extends Exception{
	
	public LimiteFuncionariosAtingidoException () {
		super ("Sinto muito, o limite de funcionarios foi atingido.");
	}
}
