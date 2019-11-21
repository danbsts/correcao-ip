package pacoteExcecoes;

public class HIException extends Exception {
	public HIException() {
		super("Horario indisponível! Agende outro horário");
	}
}
