package mesas;

import funcionarios.Funcionario;
import pedidos.RepositorioPedidos;

public interface RepositorioMesa {
	
	void inserirMesa(Mesa mesa);
	void removerMesa(Mesa mesa);
	boolean existe(Mesa mesa);
	void atualizarMesa(Mesa mesa, int numeroMesa, Funcionario funcionario, RepositorioPedidos pedidos );
	int quantidadeMesas(Funcionario funcionario);
	Mesa procurarMesa(int identificadorMesa);
	boolean existeMesa(int identificadorMesa);

}
