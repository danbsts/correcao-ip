package dados;
import carros.*;

public class RepositorioCarrosArray implements RepositorioCarros {
	private int indice;
	private Carros[] carros = new Carros[indice];
	
	
	public RepositorioCarrosArray(int tamanho) {
		carros = new Carros[tamanho];
		indice = 0;
	}
	

	public void inserir(Carros carro) {
		carros[indice] = carro;
		indice ++;
	}
	

	public Carros procurar(String p) {
		boolean achou = false;
		Carros c = null;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					c = carros[i];
					achou = true;
				}
			}
		}
		return c;
	}
	
	
	public void remover(String p) {
		carros[getIndice(p)] = null;
	}

	
	public void atualizar(Carros carro, String p) {
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					carros[i] = carro;
					achou = true;
				}
			}
		}
	}

	
	public boolean existePlaca(String p) {
		for (int i = 0; i < indice; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					return true;
				}
			}
		}
		return false;
	}


	public int getIndice(String p) {
		int ind = 0;
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					ind = i;
					achou = true;
				}
			}
		}
		return ind;
	}
	

	public boolean isAlugado(String p) {
		boolean achou = false;
		boolean alugado = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					achou = true;
					if (carros[i].isAlugado()) {
						alugado = true;
					}
				}
			}
		}
		return alugado;
	}
}
