package Cliente;

public class ClienteJaCadastradoException extends Exception{
	public ClienteJaCadastradoException() {
		super("Cliente já foi cadastrado!");
	}
}