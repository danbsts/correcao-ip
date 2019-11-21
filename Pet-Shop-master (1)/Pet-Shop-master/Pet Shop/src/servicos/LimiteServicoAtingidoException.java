package servicos;

public class LimiteServicoAtingidoException extends Exception {
	public LimiteServicoAtingidoException () {
		super ("Limite de servicos cadastrados atingido");
	}
}
