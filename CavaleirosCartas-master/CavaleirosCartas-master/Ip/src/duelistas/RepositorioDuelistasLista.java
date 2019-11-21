
package duelistas;

import excecoes.*;


public class RepositorioDuelistasLista implements RepositorioDuelistas {

	private Duelista duelista;
	private RepositorioDuelistasLista prox;
	public RepositorioDuelistasLista() {
		this.duelista = null;
		this.prox = null;
	}
	//Método que insere o objeto no repositorio
	public void inserir(Duelista duelista) {
		if (this.duelista == null) {
			this.duelista = duelista;
			this.prox = new RepositorioDuelistasLista();
		} else {
			this.prox.inserir(duelista);
		}
	}
	//Método que remove o objeto no repositorio
	public Duelista procurar(int id) throws NaoEncontradoException {
		Duelista aux = null;
		if (this.duelista != null) {
			if (this.duelista.getId() == id) {
				aux = this.duelista;
			} else {
				this.prox.procurar(id);
			}
			return aux;
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que retorna ou não um objeto dado o ID
	public void remover(int id) throws NaoEncontradoException {
		if (this.duelista != null) {
			if (this.duelista.getId() == id) {
				this.duelista = this.prox.duelista;
				this.prox = this.prox.prox;
			} else {
				this.prox.remover(id);
			}
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que substitui um objeto dado ID por outro objeto passado como parametro no repositorio
	public void atualizar (int id, Duelista duelista) throws NaoEncontradoException {
		if(this.duelista != null) {
			if(this.duelista.getId() == id) {
				this.duelista = duelista;
			}else {
				this.prox.atualizar(id , duelista);
			}
		}else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que retorna um boolean indicando se o objeto esta ou não no repositorio
	public boolean existe(int id) {
		boolean aux = false;
		if (this.duelista != null) {
			if (this.duelista.getId() == id) {
				aux = true;
			} else {
				aux = this.prox.existe(id);
			}
		} 
		return aux;
	}
}