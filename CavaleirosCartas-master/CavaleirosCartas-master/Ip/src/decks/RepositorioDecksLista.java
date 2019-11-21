package decks;

import excecoes.NaoEncontradoException;

public class RepositorioDecksLista implements RepositorioDecks{
	private Deck deck;
	private RepositorioDecksLista prox;

	public RepositorioDecksLista() {
		this.deck = null;
		this.prox = null;
	}
	//Método que insere o objeto no repositorio
	public void inserir(Deck deck) {
		if (this.deck == null) {
			this.deck = deck;
			this.prox = new RepositorioDecksLista();
		} else {
			this.prox.inserir(deck);
		}
	}
	//Método que remove o objeto no repositorio
	public void remover(int id) throws NaoEncontradoException {

		if (this.deck != null) {
			if (this.deck.getId() == id) {
				this.deck = this.prox.deck;
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
	public Deck procurar(int id) throws NaoEncontradoException {
		Deck aux = null;
		if (this.deck != null) {
			if (this.deck.getId() == id) {
				aux = this.deck;
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
	public void atualizar(int id, Deck deck) throws NaoEncontradoException {

		if (this.deck != null) {
			if (this.deck.getId() == id) {
				this.deck = deck;
			} else {
				this.prox.atualizar(id, deck);
			}
		} else {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}
	}
	//Método que retorna um boolean indicando se o objeto esta ou não no repositorio
	public boolean existe(int id){
		boolean aux = false;
		if (this.deck != null) {
			if (this.deck.getId() == id) {
				aux = true;
			} else {
				aux = this.prox.existe(id);
			}
		} 
		return aux;
	}

}
