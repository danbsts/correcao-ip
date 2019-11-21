package venda;

import cliente.RepositorioCliente;
import funcionario.Funcionario;
import funcionario.RepositorioFuncionario;
import pessoa.Pessoa;





public class CadastroVenda {
	private RepositorioVenda repo;

	
	public CadastroVenda(RepositorioVenda repositorioVenda) {
		this.repo = repositorioVenda;
	}
	
	
	public void cadastrar(Venda venda, RepositorioCliente clientesCadastrados, RepositorioFuncionario funcionarios)
			throws InserirExistenteException {
		if (repo.existe(venda)) {
			//erro de venda ja existente
			InserirExistenteException e = new InserirExistenteException(venda);
			throw e;
		} 
		// aqui estavam os erros de tentativa de inserir uma venda invalida(cliente ou funcionario invalido), porem esse erro esta em Venda.java
		
		else {
			repo.inserir(venda);
		}

	}
	
	
	
	public boolean existe(Venda venda) {
		
		return repo.existe(venda);
	
	}
	
	
	
	public Venda buscar(int id) throws BuscaIdException {
		
		return repo.buscar(id);
		
		
	}

	
	
	
	public void atualizar(Venda vendaAntiga, Venda vendaAtualizada) throws VendaNaoEncontradaException{
		
		repo.atualizar(vendaAntiga, vendaAtualizada);
		
	}
	
	
	public void remover ( Venda venda) throws VendaNaoEncontradaException{
		repo.remover(venda);
		
	}
}
