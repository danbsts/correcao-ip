package cliente;

public class ClienteExiste extends Exception {
	private Cliente cliente;

	public ClienteExiste(Cliente cliente) {
		super("Cliente já cadastrado");
this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
