package pratos;

import ingredientes.Ingrediente;

public class RepositorioPratosArray implements RepositorioPratos {
	private Prato[] arrayPratos;
	private int cont;

	public RepositorioPratosArray(int tamanho) {
		this.arrayPratos = new Prato[tamanho];
		this.cont = 0;
	}

	public void adicionarPrato(Prato prato) {
		arrayPratos[cont] = prato;
		cont++;
	}

	public void removerPrato(Prato prato) {
		for (int i = 0; i < cont; i++) {
			if (arrayPratos[i] == prato) {
				for (int k = i + 1; k < cont; k++) {
					arrayPratos[k - 1] = arrayPratos[k];
				}
			}
		}
		cont--;

	}

	public String listarPrato() {
		String retorno = "-------- Cardápio --------" + "\n";
		for (int i = 0; i < cont; i++) {
			retorno += "Nome: " + arrayPratos[i].getNome() + "\n" + "Preço: " + arrayPratos[i].getPreco() + "\n"
					+ "Ingredientes: " + listarIngredientes(arrayPratos[i]) + "\n" + "--------------------------" + "\n";
		}
		return retorno;
	}

	public String listarIngredientes(Prato prato) {
		String retorno = "";
		for (int x = 0; x < cont; x++) {
			if (arrayPratos[x] == prato) {
				for (int i = 0; i < arrayPratos[x].getIngredientes().length; i++) {
					if (i == arrayPratos[x].getIngredientes().length - 1) {
						retorno += arrayPratos[x].getIngredientes()[i].getNome() + ".";
					} else {
						retorno += arrayPratos[x].getIngredientes()[i].getNome() + ", ";
					}

				}

			}

		}
		return retorno;
	}

	public boolean existePrato(String nomePrato) {
		boolean retorno = false;
		for (int i = 0; i < cont; i++) {
			if (arrayPratos[i].getNome().equals(nomePrato)) {
				retorno = true;
			}
		}
		return retorno;
	}

	public void atualizarPrato(int identificador, String nome, double preco, Ingrediente[] ingredientes) {
		for (int i = 0; i < cont; i++) {
			if (arrayPratos[i].getIdentificador() == identificador) {
				arrayPratos[i].setNome(nome);
				arrayPratos[i].setPreco(preco);
				arrayPratos[i].setIngrediente(ingredientes);
			}
		}
		
	}
	
	public Prato procurarPrato(String nomePrato) {
			Prato resposta = null;
			for (int i = 0; i < this.arrayPratos.length; i++) {
				if (this.arrayPratos[i].getNome().equals(nomePrato)) {
					resposta = this.arrayPratos[i];
				}
			}	
			return resposta;
	}

}
