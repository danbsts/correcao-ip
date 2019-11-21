package entregador;

import mercadoria.RepositorioMercadoriaLista;
import vendas.ExisteVendaException;
import vendas.NaoExisteException;
import vendas.RepositorioListaVendas;
import vendas.Vendas;

public class RepositorioEntregadoresLista implements RepositorioEntregadores {
	private Entregador entregador;
	private RepositorioEntregadoresLista next;

	public RepositorioEntregadoresLista() {
		this.entregador = null;
		this.next = null;
	}

	public RepositorioEntregadoresLista(Entregador entregador) {
		this.entregador = entregador;
		this.next = null;
	}

	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		if (this.entregador == null) {
			this.entregador = entregador;
			this.next = new RepositorioEntregadoresLista();
		} else {
			this.next.inserirEntregador(entregador);

		}
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException {
		if (this.entregador != null) {
			this.entregador = this.next.entregador;
			this.next = this.next.next;
		} else {
			throw new EntregadorNaoEncontradoException();
		}
	}

	public boolean verificarEntregador(String cpf) {
		while (this.entregador != null) {
			if (this.entregador.getCpf().equals(cpf)) {
				return true;
			}
			this.next.verificarEntregador(cpf);
		}
		return false;
	}

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		if(this.entregador!=null&&this.entregador.getCpf().equals(entregador.getCpf())) {
			this.entregador=entregador;
		}
		else if(this.next!=null) {
			this.next.atualizarEntregador(entregador);
		}
		else {
			throw new EntregadorNaoEncontradoException();	
		}
	}
	
	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException{
		if(this.entregador!=null&&this.entregador.getCpf().equals(cpf)) {
			return entregador;
		}
		else if(this.next==null)
			throw new EntregadorNaoEncontradoException();
		else {
			return this.next.procurarEntregador(cpf);
		}
	}
	

}
