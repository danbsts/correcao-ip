package fachada;

import pedidos.CadastroPedidos;
import pedidos.PedidoJaExistenteException;
import pedidos.PedidoNaoEncontradoException;
import pedidos.Pedidos;
import pedidos.RepositorioPedidos;
import pedidos.ValorInvalidoException;
import pessoas.CadastroPessoas;
import pessoas.Pessoa;
import pessoas.CpfInvalidoException;
import pessoas.PessoaJaExistenteException;
import pessoas.PessoaNaoEncontradaException;
import pessoas.Repositorio;
import pessoas.Garcom;
import produtos.CadastroProdutos;
import produtos.Produto;
import produtos.ProdutoJaCadastradoException;
import produtos.ProdutoNaoEncontradoException;
import produtos.RepositorioProdutos;

public class Fachada {
	//M�todos que chamam todas as funcionalidades dos cadastros.
	//olhar os exception de cadastro que tao meio errados tipo  deveria ter pedido ja cadastrado porem nao ta criado e afins esse codigo ta cheio de erro eu vou me matar ahhhhhhhhhhhhhhhhh
	private CadastroPessoas cadastroPessoasGarcom;
	private CadastroPessoas cadastroPessoasClientes;
	private CadastroProdutos cadastroProdutos;
	private CadastroPedidos cadastroPedidos;

	public Fachada
	(Repositorio repositorioPessoasFuncionarios, Repositorio repositorioPessoasClientes, RepositorioProdutos repositorioProdutos, RepositorioPedidos repositorioPedidos) {
		this.cadastroPessoasGarcom = new CadastroPessoas(repositorioPessoasFuncionarios);
		this.cadastroPessoasClientes = new CadastroPessoas(repositorioPessoasClientes);
		this.cadastroProdutos = new CadastroProdutos(repositorioProdutos);
		this.cadastroPedidos = new CadastroPedidos(repositorioPedidos);
	}

	public void cadastrarPessoas(Pessoa cliente) throws PessoaJaExistenteException, CpfInvalidoException{
		cadastroPessoasClientes.cadastrar(cliente);
	} 

	public void atualizarPessoas(Pessoa cliente) throws PessoaNaoEncontradaException, CpfInvalidoException {
		cadastroPessoasClientes.atualizar(cliente);
	}

	public void removerPessoas(String codigo) throws PessoaNaoEncontradaException, CpfInvalidoException {
		cadastroPessoasClientes.remover(codigo);
	}

	public Pessoa procurarPessoas(String codigo) throws PessoaNaoEncontradaException,CpfInvalidoException {
		return (Pessoa) cadastroPessoasClientes.procurar(codigo);
	}

	public boolean existePessoas(String codigo) {
		return cadastroPessoasClientes.existe(codigo);
	}

	public void cadastrarFuncionario(Garcom cliente) throws PessoaJaExistenteException, Exception {
		cadastroPessoasGarcom.cadastrar(cliente);
	}

	public void atualizarFuncionario(Garcom cliente) throws PessoaNaoEncontradaException, Exception {
		cadastroPessoasGarcom.atualizar(cliente);
	}

	public void removerFuncionario(String codigo) throws PessoaNaoEncontradaException, CpfInvalidoException{
		cadastroPessoasGarcom.remover(codigo);
	}

	public Garcom procurarFuncionario(String codigo) throws PessoaNaoEncontradaException, Exception {
		return (Garcom) cadastroPessoasGarcom.procurar(codigo);
	}

	public boolean existeFuncionario(String codigo) {
		return cadastroPessoasGarcom.existe(codigo);
	}

	public void cadastrarProdutos(Produto produto) throws ProdutoJaCadastradoException, ValorInvalidoException {
		cadastroProdutos.cadastrar(produto);
	}

	public void atualizarProdutos(Produto produto) throws ProdutoNaoEncontradoException {
		cadastroProdutos.atualizar(produto);
	}

	public void removerProduto(String nome) throws ProdutoNaoEncontradoException {
		cadastroProdutos.remover(nome);
	}

	public Produto procurarProduto(String nome) throws ProdutoNaoEncontradoException {
		return cadastroProdutos.procurar(nome);
	}

	public boolean existeProduto(String nome) {
		return cadastroProdutos.existe(nome);
	}

	public void cadastrarPedido(Pedidos pedido) throws PedidoJaExistenteException, PessoaNaoEncontradaException, PedidoNaoEncontradoException, ValorInvalidoException {
		if (!cadastroPessoasClientes.existe(pedido.getCliente().getCpf())) { 
			throw new PessoaNaoEncontradaException(pedido.getCliente().getNome());
		} else if (!cadastroPessoasGarcom.existe(pedido.getFuncionario().getCpf())) {
			throw new PessoaNaoEncontradaException(pedido.getFuncionario().getNome());
		} else {
			cadastroPedidos.cadastrar(pedido);
		}
	}

	public void atualizarPedido(Pedidos pedido) throws PedidoNaoEncontradoException, PessoaNaoEncontradaException, ValorInvalidoException {
		if (!cadastroPessoasClientes.existe(pedido.getCliente().getCpf())) { 
			throw new PessoaNaoEncontradaException(pedido.getCliente().getNome());
		} else if (!cadastroPessoasGarcom.existe(pedido.getFuncionario().getCpf())) {
			throw new PessoaNaoEncontradaException(pedido.getFuncionario().getNome());
		} else {
			cadastroPedidos.atualizar(pedido);
		}
	}

	public void removerPedido(String codigo) throws PedidoNaoEncontradoException {
		cadastroPedidos.remover(codigo);
	}

	public Pedidos procurarPedido(String codigo) throws PedidoNaoEncontradoException, ValorInvalidoException {
		return cadastroPedidos.procurar(codigo);
	}

	public boolean existePedido(String codigo) {
		return cadastroPedidos.existe(codigo);
	}

}

