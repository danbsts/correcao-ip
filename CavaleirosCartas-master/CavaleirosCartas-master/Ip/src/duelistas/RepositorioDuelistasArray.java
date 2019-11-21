package duelistas;

import excecoes.*;

public class RepositorioDuelistasArray implements RepositorioDuelistas {

	private Duelista[] duelistas;

	public RepositorioDuelistasArray() {
		this.duelistas = new Duelista[20];
	}
	//Método que insere o objeto no repositorio
	public void inserir(Duelista duelista) throws ArrayCheioException {
		boolean aux = false;
		for (int k = 0; k < this.duelistas.length && !aux ; k++) {
			if (this.duelistas[k] == null) {
				this.duelistas[k] = duelista;
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
			for (int k = 0; k < duelistas.length; k++) {
				if (this.duelistas[k] != null && this.duelistas[k].getId() == id) {
					this.duelistas[k] = null;
				}
			}
		}
	}
	//Método que retornar um objeto dado o ID, no repositorio
	public Duelista procurar(int id) throws NaoEncontradoException {
		Duelista aux = null;
		boolean achou = false;
		for (int k = 0; k < duelistas.length; k++) {

			if (this.duelistas[k] != null && this.duelistas[k].getId() == id) {
				aux = this.duelistas[k];
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
	public void atualizar(int id, Duelista duelista) throws NaoEncontradoException {
		boolean achou = false;
		for (int k = 0; k < duelistas.length && !achou; k++) {
			if (this.duelistas[k] != null && this.duelistas[k].getId() == id) {
				this.duelistas[k] = duelista;
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
		for (int k = 0; k < this.duelistas.length && !achou; k++) {
			if (this.duelistas[k] != null && this.duelistas[k].getId() == id) {
				achou = true;
			}
		}
		return achou;
	}

}