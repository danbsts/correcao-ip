package cliente;

public class ClienteNRemovidoException extends Exception {
	private Cliente cliente;

	public ClienteNRemovidoException(Cliente cliente) {
		super("Cliente não removido, pois não existe");
		this.cliente= cliente;

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
