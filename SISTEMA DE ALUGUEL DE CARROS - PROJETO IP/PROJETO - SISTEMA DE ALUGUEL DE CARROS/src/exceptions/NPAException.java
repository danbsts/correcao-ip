package exceptions;

public class NPAException extends Exception {
	public NPAException() {
		super ("N�o foi poss�vel atualizar o ve�culo. O carro est� sendo alugado!");
	}
}
