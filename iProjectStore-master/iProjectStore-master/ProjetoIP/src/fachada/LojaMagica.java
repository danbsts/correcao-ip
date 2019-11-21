package fachada;

import Cliente.*;
import entregador.*;
import mercadoria.*;
import vendas.*;
import funcionario.*;

public class LojaMagica {
	private CadastroMercadorias mercadoria;
	private CadastroVendas vendas;
	private CadastroEntregador entregador;
	private CadastroCliente cliente;
	private CadastroFuncionarios funcionario;

	public LojaMagica(RepositorioMercadoria mercadoria, VendasInterface vendas, RepositorioEntregadores entregador,
			RepositorioCliente cliente, RepositorioFuncionarios funcionario) {
		this.mercadoria = new CadastroMercadorias(mercadoria);
		this.vendas = new CadastroVendas(vendas);
		this.entregador = new CadastroEntregador(entregador);
		this.cliente = new CadastroCliente(cliente);
		this.funcionario = new CadastroFuncionarios(funcionario);
	}

	/// MERCADORIA ////////////////////

	public void cadastrarMercadoria(Mercadoria mercadoria) throws MercadoriaJaCadastradaException {
		if (this.mercadoria.existe(mercadoria.getId())) {
			MercadoriaJaCadastradaException e;
			e = new MercadoriaJaCadastradaException();
			throw e;
		} else {
			this.mercadoria.cadastrar(mercadoria);
		}
	}

	public void removerMercadoria(int id) throws MercadoriaNaoEncontradaException {
		this.mercadoria.remover(id);
	}

	public boolean verificarMercadoria(int id) {
		return this.mercadoria.existe(id);
	}

	public void atualizarMercadoria(Mercadoria mercadoria) throws MercadoriaNaoEncontradaException {
		if (this.mercadoria.existe(mercadoria.getId())) {
			this.mercadoria.atualizar(mercadoria);
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}
	}

	public Mercadoria procurarMercadoria(int id) throws MercadoriaNaoEncontradaException {
		return this.mercadoria.procurar(id);
	}

	/// VENDA ////////////////////

	public void inserirVenda(Vendas sale) throws ExisteVendaException {
		this.vendas.VendaInserir(sale);
	}

	public void removerVenda(String id) throws NaoExisteException {
		this.vendas.VendaRemover(id);
	}

	public boolean verificarVenda(String id) throws NaoExisteException {
		return this.vendas.VendaExiste(id);
	}

	public void atualizarVenda(Vendas sale) throws NaoExisteException {
		this.vendas.VendaAtualizar(sale);
	}

	public Vendas procurarVenda(String id) throws NaoExisteException {
		return this.vendas.VendaProcurar(id);
	}

	/// ENTREGADOR ////////////////////

	public void cadastrarEntregador(Entregador Entregadores) throws EntregadorJaCadastroException {
		if (this.entregador.verificarEntregador(Entregadores.getCpf())) {
			EntregadorJaCadastroException e;
			e = new EntregadorJaCadastroException();
			throw e;
		} else {
			this.entregador.cadastrarEntregador(Entregadores);
		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		this.entregador.removerEntregador(cpf);
	}

	public boolean verificarEntregador(String cpf) {
		return this.entregador.verificarEntregador(cpf);
	}

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		this.entregador.atualizarEntregador(entregador);
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		return this.entregador.procurarEntregador(cpf);
	}

	/// CLIENTE ////////////////////

	public void cadastrarCliente(Cliente cliente) throws ClienteJaCadastradoException {
		if (!this.cliente.existe(cliente.getCpf())) {
			this.cliente.inserir(cliente);
		} else {
			ClienteJaCadastradoException e;
			e = new ClienteJaCadastradoException();
			throw e;
		}
	}

	public boolean verificarCliente(String cpf) {
		return this.cliente.existe(cpf);
	}

	public void atualizarCliente(Cliente cliente) throws ClienteNaoEncontradoException {
		this.cliente.atualizar(cliente);
	}

	public void removerCliente(String cpf) throws ClienteNaoEncontradoException {
		this.cliente.remover(cpf);
	}

	public Cliente procurarCliente(String cpf) throws ClienteNaoEncontradoException {
		return this.cliente.procurar(cpf);
	}

	/// FUNCIONARIO ////////////////////

	public void cadastrarFuncionario(Funcionarios funcionario) throws FuncionarioJaCadastradoException {
		if (!this.funcionario.existe(funcionario.getCpf()))
			this.funcionario.inserir(funcionario);
		else
			throw new FuncionarioJaCadastradoException();
	}

	public void removerFuncionario(Funcionarios funcionario) throws FuncionarioInexistenteException {
		if (this.funcionario.existe(funcionario.getCpf()) == true)
			this.funcionario.remover(funcionario);
		else
			throw new FuncionarioInexistenteException();
	}

	public void atualizarFuncionario(Funcionarios funcionario) throws FuncionarioInexistenteException {
		if (this.funcionario.existe(funcionario.getCpf()) == true)
			this.funcionario.atualizar(funcionario);
		else
			throw new FuncionarioInexistenteException();
	}

	public Funcionarios procurarFuncionario(String cpf) throws FuncionarioInexistenteException {
		if (this.funcionario.existe(cpf) == false)
			throw new FuncionarioInexistenteException();
        else
		return this.funcionario.procurar(cpf);

	}

	public boolean verificarFuncionario(String cpf) {
		return this.funcionario.existe(cpf);
	}

}
