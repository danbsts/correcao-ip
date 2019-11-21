package fachada;

import cliente.CadastroCliente;
import cliente.CamposInvalidoException;
import cliente.Cliente;
import cliente.ClienteExisteException;
import cliente.ClienteNAtualizadoException;
import cliente.ClienteNExisteException;
import cliente.ClienteNRemovidoException;
import cliente.RepositorioCliente;
import funcionario.CadastroFuncionario;
import funcionario.Funcionario;
import funcionario.FuncionarioCadastradoException;
import funcionario.FuncionarioNaoExisteException;
import funcionario.RepositorioFuncionario;
import produto.CadastroProduto;
import produto.NomeProdutoInvalidoException;
import produto.Produto;
import produto.ProdutoInexistenteException;
import produto.ProdutoJaExistenteException;
import produto.ProdutoNaoAtualizadoException;
import produto.ProdutoNaoEncontradoException;
import produto.ProdutoNaoRemovidoException;
import produto.ProdutoVazioException;
import produto.RepositorioProduto;
import produto.ValorDeCompraeVendaException;
import produto.ValorProdutoException;
import servicoDeEntrega.CadastroServicoDeEntrega;
import servicoDeEntrega.DIException;
import servicoDeEntrega.FreteInexistenteException;
import servicoDeEntrega.FreteJaExistenteException;
import servicoDeEntrega.FreteVazioException;
import servicoDeEntrega.IdentException;
import servicoDeEntrega.RepositorioServicoEntrega;
import servicoDeEntrega.ServicoDeEntrega;
import servicoDeEntrega.tipoEntException;
import venda.BuscaIdException;
import venda.CadastroVenda;
import venda.InserirExistenteException;
import venda.PessoaNaoCadastradoException;
import venda.RepositorioVenda;
import venda.Venda;
import venda.VendaNaoEncontradaException;

public class Fachada {
	private CadastroCliente cliente;
	private CadastroVenda venda;
	private CadastroServicoDeEntrega frete;
	private CadastroFuncionario funcionario;
	 private CadastroProduto produto;

	public Fachada(RepositorioCliente repositorioCliente, RepositorioServicoEntrega repositorioServicoDeEntrega,RepositorioVenda repositorioVenda, RepositorioFuncionario repositoriofuncionario,RepositorioProduto repositorioProduto) {
		this.cliente = new CadastroCliente(repositorioCliente);
		this.frete = new CadastroServicoDeEntrega(repositorioServicoDeEntrega);
		this.venda= new CadastroVenda(repositorioVenda);
		this.funcionario= new CadastroFuncionario(repositoriofuncionario);
		this.produto= new CadastroProduto(repositorioProduto);
	}

	public void cadastrarCliente(Cliente cliente) throws ClienteExisteException, CamposInvalidoException {
		this.cliente.cadastrar(cliente);
	}

	public Cliente buscarCliente(String nome, String cpf) throws ClienteNExisteException {
		return this.cliente.buscar(nome, cpf);
	}

	public boolean existeCliente(String nome, String cpf) {
		return this.cliente.existe(nome, cpf);
	}

	public void removerCliente(Cliente cliente) throws ClienteNRemovidoException {
		this.cliente.remover(cliente);
	}

	public void atualizarCliente(Cliente cliente, Cliente clienteNovo) throws ClienteNAtualizadoException {
		this.cliente.atualizar(cliente, clienteNovo);
	}

	
	
	
	public void cadastrarServicoDeEntrega(ServicoDeEntrega frete)
			throws FreteJaExistenteException, FreteVazioException, DIException, IdentException, tipoEntException {
		this.frete.cadastrarFrete(frete);
	}

	public boolean existeServicoDeEntrega(int identificador) throws IdentException {
		return this.frete.existeFrete(identificador);
	}

	public void removerServicoDeEntrega(int identificador) throws FreteInexistenteException, IdentException {
		this.frete.removerFrete(identificador);
	}

	public ServicoDeEntrega procurarServicoDeEntrega(int identificador)
			throws FreteInexistenteException, IdentException {
		return this.frete.procurarFrete(identificador);
	}

	public void atualizarServicoDeEntrega(int identificador, ServicoDeEntrega newFrete)
			throws FreteInexistenteException, IdentException {
		this.frete.atualizarFrete(identificador, newFrete);
	}

	public void cadastrarVenda(Venda venda,RepositorioCliente clientesCadastrados,RepositorioFuncionario funcionarios) throws InserirExistenteException, PessoaNaoCadastradoException {
		this.venda.cadastrar(venda, clientesCadastrados, funcionarios);
	}
	public boolean existeVenda(Venda venda) {
		return this.venda.existe(venda);
	}
	public void removerVenda(Venda venda) throws VendaNaoEncontradaException {
		this.venda.remover(venda);
	}
	public Venda buscarVenda(int id) throws BuscaIdException {
		return this.venda.buscar(id);
	}
	public void atualizarVenda(Venda vendaAntiga,Venda vendaAtualizada) throws VendaNaoEncontradaException {
		this.venda.atualizar(vendaAntiga, vendaAtualizada);
	}
	
	

	public void cadastrarfuncionario(Funcionario funcionario) throws FuncionarioCadastradoException {	
		this.funcionario.cadastrar(funcionario);
	}
	
	public void removerfuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
		this.funcionario.remover(funcionario);
	}
	public Funcionario procurarfuncionario(String cpf) throws FuncionarioNaoExisteException {
		return this.funcionario.procurar(cpf);
	}
	public void atualizarfuncionario(Funcionario funcionario) throws FuncionarioNaoExisteException {
		this.funcionario.atualizar(funcionario);
	}
	
	
	public void cadastrarProduto(Produto produto)
			throws ProdutoJaExistenteException, ProdutoInexistenteException, NomeProdutoInvalidoException, ProdutoNaoAtualizadoException, ValorProdutoException, ValorDeCompraeVendaException, ProdutoVazioException {
		this.produto.CadastrarProduto(produto);
	 }
		public void RemoverProduto(String nomeproduto) throws ProdutoNaoRemovidoException, NomeProdutoInvalidoException,
		NomeProdutoInvalidoException, ProdutoInexistenteException {
			this.produto.RemoverProduto(nomeproduto);	
		}
		public boolean ExisteProduto(String nomeproduto)
				throws ProdutoInexistenteException, ProdutoNaoEncontradoException, NomeProdutoInvalidoException {
			return this.produto.ExisteProduto(nomeproduto);
		}
		public Produto ProcurarProduto(String nomeproduto)
			throws NomeProdutoInvalidoException, ProdutoNaoEncontradoException, ProdutoInexistenteException {
		 return this.produto.ProcurarProduto(nomeproduto);
	}	
		public void AtualizarProduto(Produto produto, String nomeproduto) throws NomeProdutoInvalidoException,
		ProdutoNaoEncontradoException, ProdutoInexistenteException, ProdutoNaoAtualizadoException {
			this.produto.AtualizarProduto(produto, nomeproduto);
		}
		
	
	
}
