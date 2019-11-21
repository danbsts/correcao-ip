package mesas;


import funcionarios.Funcionario;
import pedidos.RepositorioPedidos;


public class Mesa {
	private Funcionario funcionario;
	private int numero;
	private RepositorioPedidos pedidos;
	
	public Mesa(Funcionario funcionario, int num, RepositorioPedidos pedidos){
		this.funcionario = funcionario;
		this.numero= num;
		this.pedidos=pedidos;

	}

	public int getNum(){
		return this.numero;
	}
	public Funcionario getFuncionario(){
		return this.funcionario;
	}
	public RepositorioPedidos getPedidos() {
		return this.pedidos;
	}

	public void setNumero(int num){
		this.numero=num;
	}
	
	public void setFuncionario(Funcionario funcionario){
		this.funcionario=funcionario;
	}
	public void setRepPedidos(RepositorioPedidos pedidos){
		this.pedidos=pedidos;

	}
}

