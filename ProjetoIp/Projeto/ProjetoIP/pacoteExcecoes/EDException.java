package pacoteExcecoes;

public class EDException extends Exception {
	public EDException () {
		super ("Esta demanda já foi cadastrada junto à esse documento, verifique sua reserva.");
	}
}
