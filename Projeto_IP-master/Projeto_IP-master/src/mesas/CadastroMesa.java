package mesas;


import funcionarios.Funcionario;
import ingredientes.RepositorioIngredientes;
import pedidos.RepositorioPedidos;
import pratos.Prato;

public class CadastroMesa {
	private RepositorioMesa repositorio;
	
	public CadastroMesa(RepositorioMesa repMesas){
		this.repositorio = repMesas;
	}
	
	public void cadastrar(Mesa mesa) throws MesaJaCadastradaException {
		if (!repositorio.existe(mesa)) {
			repositorio.inserirMesa(mesa);
			
		}else {
			throw new MesaJaCadastradaException();
		}
	}
	
	public void remover(Mesa mesa) throws MesaNaoCadastradaException{
		if (repositorio.existe(mesa)) {
			repositorio.removerMesa(mesa);
		}else {
			throw new MesaNaoCadastradaException();
		}
	}
	
	public void listar() {}
	
	
	
	public void atualizar(Mesa mesa ,int numeroMesa, Funcionario funcionario, RepositorioPedidos pedidos) throws MesaNaoCadastradaException {
		if (repositorio.existe(mesa)) {
			repositorio.atualizarMesa(mesa, numeroMesa, funcionario, pedidos);
		}else {
			throw new MesaNaoCadastradaException();
		}
	}	
	public RepositorioMesa getMesas() {
		return this.repositorio;
	}
	
	//Metodo que tava no repositorio botei aqui tambem
	public double quantidadeMesas(Funcionario funcionario) {
		return this.repositorio.quantidadeMesas(funcionario);
	}
	
	public Mesa procurarMesa(int identificadorMesa) throws MesaNaoCadastradaException {
	if(repositorio.existeMesa(identificadorMesa)) {
		return repositorio.procurarMesa(identificadorMesa);
	} else {
		throw new MesaNaoCadastradaException();
	}
	}
	
	public boolean existe(int identificadorMesa) {
		if(repositorio.existeMesa(identificadorMesa)) {
			return true;
		} else {
			return false;
		}
	}

}
