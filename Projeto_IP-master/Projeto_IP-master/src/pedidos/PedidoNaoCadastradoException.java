package pedidos;

public class PedidoNaoCadastradoException extends Exception{
public PedidoNaoCadastradoException() {
	super ("Esse pedido nao existe.");
}
}
