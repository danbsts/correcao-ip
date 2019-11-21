package entregador;

import mercadoria.Mercadoria;
import mercadoria.MercadoriaJaCadastradaException;

public class CadastroEntregador {

	private RepositorioEntregadores repositorio;

	public CadastroEntregador(RepositorioEntregadores repo) {
		repositorio = repo;
	}

	public void cadastrarEntregador (Entregador entregador) throws EntregadorJaCadastroException{
		if (!this.repositorio.verificarEntregador(entregador.getCpf())) {
			this.repositorio.inserirEntregador(entregador);
		} else {
			EntregadorJaCadastroException e;
			e = new EntregadorJaCadastroException();
			throw e;
		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		this.repositorio.removerEntregador(cpf);
	}

	public boolean verificarEntregador(String cpf) {
		return this.repositorio.verificarEntregador(cpf);
	}

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		this.repositorio.atualizarEntregador(entregador);
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		return this.repositorio.procurarEntregador(cpf);
	}

}	
