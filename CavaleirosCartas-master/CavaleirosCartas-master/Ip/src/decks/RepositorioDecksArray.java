package decks;

import excecoes.ArrayCheioException;
import excecoes.NaoEncontradoException;

public class RepositorioDecksArray implements RepositorioDecks {
	private Deck[] decks;

	public RepositorioDecksArray() {
		this.decks = new Deck[20];
	}
	//Método que insere o objeto no repositorio
	public void inserir(Deck deck) throws ArrayCheioException {
		boolean aux = false;
		for (int k = 0; k < this.decks.length && !aux; k++) {
			if (this.decks[k] == null) {
				this.decks[k] = deck;
				aux = true;
			}
		}
		if(!aux) {
			ArrayCheioException e = new ArrayCheioException();
			throw e;
		}
	}
	//Método que remove o objeto no repositorio
	public void remover(int id) throws NaoEncontradoException {

		if (!existe(id)) {
			throw new NaoEncontradoException();
		} else {
			for (int k = 0; k < decks.length; k++) {
				if (this.decks[k] != null && this.decks[k].getId() == id) {
					this.decks[k] = null;
				}
			}
		}
	}
	//Método que retornar um objeto dado o ID, no repositorio
	public Deck procurar(int id) throws NaoEncontradoException {
		Deck aux = null;
		boolean achou = false;
		for (int k = 0; k < decks.length; k++) {

			if (this.decks[k] != null && this.decks[k].getId() == id) {
				aux = this.decks[k];
				achou = true;
			}

		}
		if (!achou) {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		} else {
			return aux;
		}

	}
	//Método que substitui um objeto dado ID por outro objeto passado como parametro no repositorio
	public void atualizar(int id, Deck deck) throws NaoEncontradoException {
		boolean achou = false;
		for (int k = 0; k < this.decks.length && !achou; k++) {
			if (this.decks[k] != null && this.decks[k].getId() == id) {
				this.decks[k] = deck;
				achou = true;
			}
		}
		if (!achou) {
			NaoEncontradoException e = new NaoEncontradoException();
			throw e;
		}

	}
	//Método que retorna um boolean indicando se o objeto esta ou não no repositorio
	public boolean existe(int id) {
		boolean achou = false;
		for (int k = 0; k < this.decks.length && !achou; k++) {
			if (this.decks[k] != null && this.decks[k].getId() == id) {
				achou = true;
			}
		}
		return achou;
	}

}