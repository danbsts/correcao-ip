package pedidos;

import pratos.Prato;

public interface RepositorioPedidos {
	void inserir(Pedidos pedido);
	void remover(Pedidos pedido);
	void atualizar(Pedidos pedido);
	boolean existe(Pedidos pedido);
	boolean existePedido(String identificadorPedido);
	Pedidos procurar(String identificadorPedido);
	double consumoMesa();
}