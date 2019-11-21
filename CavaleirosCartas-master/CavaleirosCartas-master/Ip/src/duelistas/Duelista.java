package duelistas;

import decks.Deck;
import extradecks.ExtraDeck;

public class Duelista {
	private String nome;
	private int id;
	private Deck deck;
	private ExtraDeck extra;

	public Duelista(String nome, int id, Deck deck, ExtraDeck extra) {
		this.nome = nome;
		this.id = id;
		this.deck = deck;
		this.extra = extra;
	}

	public void setExtra(ExtraDeck extra) {
		this.extra = extra;
	}

	public ExtraDeck getExtra() {
		return this.extra;
	}

	public String getNome() {
		return this.nome;
	}

	public int getId() {
		return this.id;
	}

	public Deck getDeck() {
		return this.deck;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}