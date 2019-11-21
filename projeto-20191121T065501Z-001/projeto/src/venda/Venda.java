package venda;

import cliente.Cliente;
import cliente.RepositorioCliente;
import funcionario.Funcionario;
import funcionario.RepositorioFuncionario;
import produto.RepositorioProduto;

public class Venda {

	private Cliente cliente;
	private Funcionario funcionario;
	private RepositorioProduto carrinho;
	private int id;
	

	public Venda(Cliente cliente, Funcionario funcionario, RepositorioProduto carrinho, int id,
			RepositorioFuncionario funcionariosDaLoja, RepositorioCliente clientesCadastrados) {
		if (!clientesCadastrados.existe(cliente.getNome(), cliente.getCpf())) {
			PessoaNaoCadastradoException e = new PessoaNaoCadastradoException(cliente, "Cliente");
		} else if (!funcionariosDaLoja.existe(funcionario.getCpf())) {
			PessoaNaoCadastradoException e = new PessoaNaoCadastradoException(funcionario, "Funcionário");
		} else {

			this.cliente = cliente;
			this.funcionario = funcionario;
			this.carrinho = carrinho;
			this.id = id;
		
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public RepositorioProduto getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(RepositorioProduto carrinho) {
		this.carrinho = carrinho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}