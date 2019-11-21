package ui;

import cartas.*;
import decks.*;
import duelistas.*;
import extradecks.*;
import excecoes.*;


public class Jogo {
	private CadastroCartas cadCartas;
	private CadastroDecks cadDecks;
	private CadastroDuelistas cadDuelistas;
	private CadastroExtraDecks cadExtraDecks;

	public Jogo(CadastroCartas cartas, CadastroDecks decks, CadastroDuelistas duelistas,
			CadastroExtraDecks extradecks) {
		this.cadCartas = cartas;
		this.cadDecks = decks;
		this.cadDuelistas = duelistas;
		this.cadExtraDecks = extradecks;
	}
	////////////// Métodos relacionados a inserção de um objeto //////////////

	///// Cartas /////
	public void registrarCarta(Carta carta) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException {
		if (cadCartas.presente(carta.getId())) {
			throw new IdJaCadastradoException();
		} else {
			cadCartas.cadastrar(carta);
		}
	}

	///// Decks /////
	public void registrarDeck(Deck deck)
			throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException, CartaNaoCadastradaException {
		boolean aux = true;
		for (int k = 0; k < deck.getBaralho().length && aux == true; k++) {
			if (deck.getBaralho()[k] != null && !cadCartas.presente(deck.getBaralho()[k].getId())) {
				aux = false;
			}
		}
		if (aux == false) {
			throw new CartaNaoCadastradaException();
		} else {
			if (cadDecks.presente(deck.getId())) {
				throw new IdJaCadastradoException();
			} else {
				cadDecks.cadastrar(deck);
			}
		}
	}

	///// Duelistas /////
	public void registrarDuelista(Duelista duelista) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException,
			DeckNaoCadastradoException, ExtraDeckNaoCadastradoException {
		if (!cadDecks.presente(duelista.getDeck().getId())) {
			throw new DeckNaoCadastradoException();
		} else if (!cadExtraDecks.presente(duelista.getExtra().getId())) {
			throw new ExtraDeckNaoCadastradoException();
		} else if (cadDuelistas.presente(duelista.getId())) {
			throw new IdJaCadastradoException();
		} else {
			cadDuelistas.cadastrar(duelista);
		}
	}

	///// ExtraDecks /////
	public void registrarExtraDeck(ExtraDeck extradeck)
			throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException, CartaNaoCadastradaException {
		boolean aux = true;
		for (int k = 0; k < extradeck.getExtra().length && aux == true; k++) {
			if (extradeck.getExtra()[k] != null && !cadCartas.presente(extradeck.getExtra()[k].getId())) {
				aux = false;
			}
		}
		if (aux == false) {
			throw new CartaNaoCadastradaException();
		} else {
			if (cadExtraDecks.presente(extradeck.getId())) {
				throw new IdJaCadastradoException();
			} else {
				cadExtraDecks.cadastrar(extradeck);
			}
		}
	}

	////////////// Métodos relacionados a remoção de um objeto //////////////

	///// Cartas /////
	public void apagarCarta(int id) throws NaoEncontradoException {
		if (!cadCartas.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			cadCartas.retirar(id);
		}
	}

	///// Decks /////
	public void apagarDeck(int id) throws NaoEncontradoException {
		if (!cadDecks.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			cadDecks.retirar(id);
		}
	}

	///// Duelistas /////
	public void apagarDuelista(int id) throws NaoEncontradoException {
		if (!cadDuelistas.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			cadDuelistas.retirar(id);
		}
	}

	///// ExtraDecks /////
	public void apagarExtraDeck(int id) throws NaoEncontradoException {
		if (!cadExtraDecks.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			cadExtraDecks.retirar(id);
		}
	}

	////////////// Métodos relacionados ao retorno de um objeto procurado ////////////// 

	///// Cartas /////
	public Carta buscarCarta(int id) throws NaoEncontradoException {
		if (!cadCartas.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			return cadCartas.buscar(id);
		}
	}

	///// Decks /////
	public Deck buscarDeck(int id) throws NaoEncontradoException {
		if (!cadDecks.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			return cadDecks.buscar(id);
		}
	}

	///// Duelistas /////
	public Duelista buscarDuelista(int id) throws NaoEncontradoException {
		if (!cadDuelistas.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			return cadDuelistas.buscar(id);
		}
	}

	///// ExtraDecks /////
	public ExtraDeck buscarExtraDeck(int id) throws NaoEncontradoException {
		if (!cadExtraDecks.presente(id)) {
			throw new NaoEncontradoException();
		} else {
			return cadExtraDecks.buscar(id);
		}
	}

	////////////// Métodos relacionados a atualização de um objeto //////////////

	///// Cartas /////
	public void retificarCarta(int id, Carta carta) throws NaoEncontradoException, IdJaCadastradoException {
		if (cadCartas.presente(id) && !(cadCartas.presente(carta.getId()))) {
			cadCartas.retificar(id, carta);
		} else {
			if (cadCartas.presente(carta.getId())) {
				throw new IdJaCadastradoException();
			} else {
				throw new NaoEncontradoException();
			}
		}
	}

	///// Decks /////
	public void retificarDeck(int id, Deck deck) throws NaoEncontradoException, IdJaCadastradoException {
		if (cadDecks.presente(id) && !(cadDecks.presente(deck.getId()))){
			cadDecks.retificar(id, deck);
		} else {
			if (cadCartas.presente(deck.getId())) {
				throw new IdJaCadastradoException();
			} else {
				throw new NaoEncontradoException();
			}
		}
	}

	///// Duelistas /////
	public void retificarDuelista(int id, Duelista duelista) throws NaoEncontradoException, IdJaCadastradoException {
		if (cadDuelistas.presente(id) && !(cadDuelistas.presente(duelista.getId()))) {
			cadDuelistas.retificar(id, duelista);
		} else {
			if (cadDuelistas.presente(duelista.getId())) {
				throw new IdJaCadastradoException();
			} else {
				throw new NaoEncontradoException();
			}
		}
	}

	///// ExtraDeck /////
	public void retificarExtraDeck(int id, ExtraDeck extradeck) throws NaoEncontradoException, IdJaCadastradoException {
		if (cadExtraDecks.presente(id) && !(cadDuelistas.presente(extradeck.getId()))) {
			cadExtraDecks.retificar(id, extradeck);
		} else {
			if (cadExtraDecks.presente(extradeck.getId())) {
				throw new IdJaCadastradoException();
			} else {
				throw new NaoEncontradoException();
			}
		}
	}

	////////////// Métodos destinados a verificar a presença de um objeto //////////////

	///// Cartas /////
	public boolean contemCarta(int id) {
		if (cadCartas.presente(id)) {
			return true;
		} else {
			return false;
		}
	}

	///// Decks /////
	public boolean contemDeck(int id) {
		if (cadDecks.presente(id)) {
			return true;
		} else {
			return false;
		}
	}

	///// Duelistas /////
	public boolean contemDuelista(int id) {
		if (cadDuelistas.presente(id)) {
			return true;
		} else {
			return false;
		}
	}

	///// ExtraDecks /////
	public boolean contemExtraDeck(int id) {
		if (cadExtraDecks.presente(id)) {
			return true;
		} else {
			return false;
		}
	}
}
