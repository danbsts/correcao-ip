package pedidos;

public class PedidoJaCadastradoException extends Exception {
	public PedidoJaCadastradoException() {
      super ("Esse pedido ja foi cadastrado.");
	}
}
