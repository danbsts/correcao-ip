package extradecks;

import excecoes.NaoEncontradoException;

public class RepositorioExtraDecksLista implements RepositorioExtraDecks {
	private ExtraDeck extra;
	private RepositorioExtraDecksLista prox;

	public RepositorioExtraDecksLista() {
		this.extra = null;
		this.prox = null;
	}
	//Método que insere o objeto no repositorio
	public void inserir(ExtraDeck extra) {
		if (this.extra == null) {
			this.extra = extra;
			this.prox = new RepositorioExtraDecksLista();
		} else {
			this.prox.inserir(extra);
		}
	}
	//Método que remove o objeto no repositorio
	public void remover(int id) throws NaoEncontradoException {

		if (this.extra != null) {
			if (this.extra.getId() == id) {
				this.extra = this.prox.extra;
				this.prox = this.prox.prox;
			} else {
				this.prox.remover(id);
			}
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que retorna ou não um objeto dado o ID
	public ExtraDeck procurar(int id) throws NaoEncontradoException {
		ExtraDeck aux = null;
		if (this.extra != null) {
			if (this.extra.getId() == id) {
				aux = this.extra;
			} else {
				this.prox.procurar(id);
			}
			return aux;
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que substitui um objeto dado ID por outro objeto passado como parametro no repositorio
	public void atualizar(int id, ExtraDeck extra) throws NaoEncontradoException {

		if (this.extra != null) {
			if (this.extra.getId() == id) {
				this.extra = extra;
			} else {
				this.prox.atualizar(id, extra);
			}
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que retorna um boolean indicando se o objeto esta ou não no repositorio
	public boolean existe(int id) {
		boolean aux = false;
		if (this.extra != null) {
			if (this.extra.getId() == id) {
				aux = true;
			} else {
				aux = this.prox.existe(id);
			}
		} 
		return aux;
	}

}

