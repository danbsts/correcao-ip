package decks;

import cartas.Carta;
import excecoes.ArrayCheioException;
import excecoes.NaoEncontradoException;

public class Deck {
	private Carta[] baralho;
	private int id;
	public Deck(int id) {
		this.baralho = new Carta[10];
		this.id = id;
	}
	
	public void inserir(Carta carta) throws ArrayCheioException {
		boolean aux = false;
		for (int k = 0; k < this.baralho.length && !aux; k++) {
			if (this.baralho[k] == null) {
				this.baralho[k] = carta;
				aux = true;
			}
		}
		if(!aux) {
			ArrayCheioException e = new ArrayCheioException();
			throw e;
		}
	}

	public void remover(int id) throws NaoEncontradoException {

		if (!existe(id)) {
			throw new NaoEncontradoException();
		} else {
			for (int k = 0; k < baralho.length; k++) {
				if (this.baralho[k] != null && this.baralho[k].getId() == id) {
					this.baralho[k] = null;
				}
			}
		}
	}
	
	public boolean existe(int id) {
		boolean achou = false;
		for (int k = 0; k < this.baralho.length; k++) {
			if (this.baralho[k] != null && this.baralho[k].getId() == id) {
				achou = true;
			}
		}
		return achou;
	}

	
	
	public Carta[] getBaralho() {
		return this.baralho;
	}

	public void setBaralho(Carta[] baralho) {
		this.baralho = baralho;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}