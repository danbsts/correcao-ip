package venda;

import funcionarios.Funcionarios;
import produtos.Produtos;
import servicos.Servicos;
import clientes.Clientes;
public class Vendas {
	private Funcionarios funcionario;
	private Clientes cliente;
	private Produtos produto;
	private Servicos servico;
	private double valor;
	private String id;
	public Vendas (Funcionarios funcionario, Clientes cliente, 
			Produtos produto, Servicos servico, double valor, String id) {
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.produto = produto;
		this.servico = servico;
		this.valor = valor;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Funcionarios getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Produtos getProduto() {
		return produto;
	}
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	public Servicos getServico() {
		return servico;
	}
	public void setServico(Servicos servico) {
		this.servico = servico;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
