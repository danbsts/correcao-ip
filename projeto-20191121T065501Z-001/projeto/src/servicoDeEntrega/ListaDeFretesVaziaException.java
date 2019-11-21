package servicoDeEntrega;

public class ListaDeFretesVaziaException extends Exception {
	public ListaDeFretesVaziaException() {
		super ("Não existem fretes em andamento!");	
	}
}
