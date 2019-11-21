package pedidos;

public class NaoExistemPedidosException extends Exception {
public NaoExistemPedidosException() {
	super ("Ainda nao foram realizados pedidos.");
}
}
