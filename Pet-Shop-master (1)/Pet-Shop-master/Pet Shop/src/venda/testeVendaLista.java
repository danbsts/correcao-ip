package venda;
import clientes.Clientes;
import funcionarios.Funcionarios;
import produtos.Produtos;
import servicos.Servicos;

public class testeVendaLista {

	public static void main(String[] args) throws VendaNaoEncontradaException {
		// TODO Auto-generated method stub
		RepositorioVendasLista repoTeste = new RepositorioVendasLista();
		/*Funcionarios funcionario = new Funcionarios ("facebookson", "321", "987", "pipi", 8000);
		Clientes cliente = new Clientes("maminha", "123", "789");
		Produtos produto = new Produtos("coleira", "2", 25, 2, "pet happy");
		Servicos servico = new Servicos("pau de 25cm de nadia", "25", 2500);
		Vendas venda = new Vendas (funcionario, cliente, produto, servico, 2.5, "1");
		Vendas novaVenda = new Vendas (funcionario, cliente, produto, servico, 70, "3");
		repoTeste.inserir(venda);
		repoTeste.inserir(novaVenda);
		Vendas novaVenda2 = new Vendas (funcionario, cliente, produto, servico, 50, "3");
		repoTeste.atualizar(novaVenda2);
		System.out.println(repoTeste.existe(novaVenda2.getId()));
		System.out.println(repoTeste.procurar(novaVenda2.getId()));
		System.out.println(repoTeste.procurar(venda.getId()));*/
		Clientes cliente = new Clientes ("thais", "95488", "99686660");
		Clientes novoCliente = new Clientes ("debora", "45472", "995672000");
		Clientes novoCliente2 = new Clientes ("nathalia", "74899", "999942444");
		Funcionarios testeF = new Funcionarios("Lorena", "123123", "123", "1", 251.8);
		Funcionarios teste1F = new Funcionarios("Gui", "12312", "123", "2", 251.8);
		Produtos teste1P = new Produtos("Ração", "F-666", 34.5, 70, "João da carne de sol");
		Produtos teste2P = new Produtos("Nsei", "F-645", 9.5, 70, "João da carne de sol");
		Produtos teste3P = new Produtos("carambolas", "F-269", 394.5, 70, "João da carne de sol");
		Servicos teste = new Servicos ("Oi", "1", 2);
		Servicos teste1 = new Servicos ("Oi", "2", 2);
		double valor1 = 25; double valor2 = 30; double valor3 = 50;
		String id = "1"; String id2 = "2"; String id3 = "3";
		Vendas venda1 = new Vendas(testeF, cliente, teste1P, teste, valor1, id);
		Vendas venda2 = new Vendas(teste1F, novoCliente, teste2P, teste1, valor2, id2);
		Vendas venda3 = new Vendas(teste1F, novoCliente2, teste3P, teste1, valor3, id3);
		repoTeste.inserir(venda1); repoTeste.inserir(venda2); repoTeste.inserir(venda3);
		System.out.println(repoTeste.existe(id));
		System.out.println(repoTeste.existe(id2));
		System.out.println(repoTeste.existe(id3));
		repoTeste.remover(id);
		System.out.println(repoTeste.existe(id));
		System.out.println(repoTeste.procurar(id2).getProduto().getFornecedor());
		repoTeste.atualizar(venda1);
		
	}

}
