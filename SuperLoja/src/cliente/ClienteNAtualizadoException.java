package cliente;

public class ClienteNAtualizadoException extends Exception {
	private Cliente cliente;

	public ClienteNAtualizadoException(Cliente cliente) {
		super("Cliente n�o existe, ent�o n�o foi atualizado");
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
