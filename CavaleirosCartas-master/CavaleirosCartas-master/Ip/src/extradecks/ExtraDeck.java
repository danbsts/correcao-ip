package extradecks;

import cartas.Carta;
import excecoes.*;

public class ExtraDeck {
	private Carta[] extra;
	private int id;
	public ExtraDeck(int id) {
		this.extra = new Carta[10];
		this.id = id;
	}

	public void inserir(Carta carta) throws ArrayCheioException {
		boolean aux = false;
		for (int k = 0; k < this.extra.length && !aux; k++) {
			if (this.extra[k] == null) {
				this.extra[k] = carta;
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
			for (int k = 0; k < this.extra.length; k++) {
				if (this.extra[k] != null && this.extra[k].getId() == id) {
					this.extra[k] = null;
				}
			}
		}
	}
	
	public boolean existe(int id) {
		boolean achou = false;
		for (int k = 0; k < this.extra.length; k++) {
			if (this.extra[k] != null && this.extra[k].getId() == id) {
				achou = true;
			}
		}
		return achou;
	}
	
	public Carta[] getExtra() {
		return this.extra;
	}

	public void setExtra(Carta[] extra) {
		this.extra = extra;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
