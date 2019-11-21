package venda;

import clientes.Clientes;
import funcionarios.Funcionarios;
import produtos.Produtos;
import servicos.Servicos;

public class testeVendaArray {

	public static void main(String[] args) throws VendaNaoEncontradaException, LimiteAtingidoException {
		// TODO Auto-generated method stub
		RepositorioVendasArray repoTeste2 = new RepositorioVendasArray();
		Funcionarios funcionario = new Funcionarios ("facebookson", "321", "987", "pipi", 8000);
		Clientes cliente = new Clientes("maminha", "123", "789");
		Produtos produto = new Produtos("coleira", "2", 25, 2, "pet happy");
		Servicos servico = new Servicos("pau de 25cm de nadia", "25", 2500);
		Vendas venda = new Vendas (funcionario, cliente, produto, servico, 2.5, "1");
		Vendas novaVenda = new Vendas (funcionario, cliente, produto, servico, 70, "3");
		repoTeste2.inserir(venda);
		repoTeste2.inserir(novaVenda);
		Vendas novaVenda2 = new Vendas (funcionario, cliente, produto, servico, 50, "3");
		repoTeste2.atualizar(novaVenda2);
		//System.out.println(repoTeste2.existe(novaVenda2.getId()));
		//System.out.println(repoTeste2.procurar(novaVenda2.getId()));
		//System.out.println(repoTeste2.procurar(venda.getId()));
		Vendas procura = repoTeste2.procurar("3");
		procura.getCliente().setCredito(250);
		System.out.println(procura.getCliente().getNome() + ", " + procura.getCliente().getCpf() 
				+ ", " + procura.getCliente().getTelefone() + ", " + procura.getCliente().getCredito());
		System.out.println(procura.getFuncionario().getNome() + ", " + procura.getFuncionario().getCodigo() + ", " 
				+ procura.getFuncionario().getSalario());
		System.out.println(procura.getProduto().getNome() + ", " + procura.getProduto().getCode() + ", " + procura.getProduto().getFornecedor() + ", " 
				+ procura.getProduto().getPrice() + ", " + procura.getProduto().getQuantidade());
		System.out.println(procura.getServico().getNome() + ", " + procura.getServico().getCodigo() 
				+ ", " + procura.getServico().getPreco());
		System.out.println(procura.getValor() + ", " + procura.getId());
		//repoTeste2.remover(novaVenda2.getId());
		//System.out.println(repoTeste2.existe(novaVenda2.getId()));
		//System.out.println(repoTeste2.procurar(novaVenda2.getId()));
		
		
		
	}
}
