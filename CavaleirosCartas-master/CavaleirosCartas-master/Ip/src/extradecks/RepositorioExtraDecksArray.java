package extradecks;

import excecoes.ArrayCheioException;
import excecoes.NaoEncontradoException;

public class RepositorioExtraDecksArray implements RepositorioExtraDecks{
	private ExtraDeck[] extradecks;
	public RepositorioExtraDecksArray() {
		this.extradecks = new ExtraDeck[20];
	}
	//Método que insere o objeto no repositorio
	public void inserir(ExtraDeck extra) throws ArrayCheioException {
		boolean aux = false;
		for (int k = 0; k < this.extradecks.length && !aux; k++) {
			if (this.extradecks[k] == null) {
				this.extradecks[k] = extra;
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
		}else {
			for (int k = 0; k < extradecks.length; k++) {
				if (this.extradecks[k] != null && this.extradecks[k].getId() == id) {
					this.extradecks[k] = null;
				}
			}
		}
	}
	//Método que retornar um objeto dado o ID, no repositorio
	public ExtraDeck procurar(int id) throws NaoEncontradoException {
		ExtraDeck aux = null;
		boolean achou = false;
		for (int k = 0; k < extradecks.length; k++) {

			if (this.extradecks[k] != null && this.extradecks[k].getId() == id) {
				aux = this.extradecks[k];
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
	public void atualizar(int id, ExtraDeck extra) throws NaoEncontradoException {
		boolean achou = false;
		for (int k = 0; k < this.extradecks.length && !achou; k++) {
			if (this.extradecks[k] != null && this.extradecks[k].getId() == id) {
				this.extradecks[k] = extra;
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
		for (int k = 0; k < this.extradecks.length && !achou; k++) {
			if (this.extradecks[k] != null && this.extradecks[k].getId() == id) {
				achou = true;
			}
		}
		return achou;
	}

}

