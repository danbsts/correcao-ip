package clientes;

public class ClienteNaoEncontradoException extends Exception{
	public ClienteNaoEncontradoException () {
		super ("Cliente n�o encontrado!");
	}
}
