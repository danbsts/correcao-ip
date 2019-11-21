package cliente;

public class ClienteNAtualizadoException extends Exception {
	private Cliente cliente;

	public ClienteNAtualizadoException(Cliente cliente) {
		super("Cliente não existe, então não foi atualizado");
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
