package servicoDeEntrega;

public class FreteInexistenteException extends Exception {
	
	public FreteInexistenteException() {
		super ("O Frete procurado nao existe!");
	}

}

