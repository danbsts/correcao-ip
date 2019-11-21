package ingredientes;

public class RepositorioIngredientesArray implements RepositorioIngredientes {
	private Ingrediente[] estoque;
	private int contadorLista;

	public RepositorioIngredientesArray() {
		estoque = new Ingrediente[100];
		contadorLista = 0;
	}

	// Adiciona algum ingrediente ao Estoque
	public void inserir(Ingrediente ingrediente) {
		this.estoque[contadorLista] = ingrediente;
		this.contadorLista++;
	}

	// Remove algum ingrediente ao Estoque
	public void remover(String identificador) {
		for (int contador = 0; contador < this.estoque.length; contador++)
			if (this.estoque[contador].getIdentificador().equals(identificador)) {
				for (; contador < this.estoque.length; contador++) {
					if (contador != (this.estoque.length - 2))
						this.estoque[contador] = this.estoque[contador + 1];
					else
						this.estoque[contador] = null;
				}
			}
		this.contadorLista--;
	}

	// Atualiza os atributos de um ingrediente no estoque
	public void atualizar(Ingrediente ingrediente) {
		for (int contador = (this.contadorLista - 1); contador >= 0; contador--)
			if (this.estoque[contador].getIdentificador().equals(ingrediente.getIdentificador()))
				this.estoque[contador] = ingrediente;
	}

	// Retorna o status de um ingrediente
	public Ingrediente procurar(String identificador) {
		Ingrediente resposta = null;
		for (int contador = 0; contador < this.estoque.length; contador++) {
			if (this.estoque[contador].getIdentificador().equals(identificador)) {
				resposta = this.estoque[contador];
			}
		}
		return resposta;
	}

	// Analisa se algum ingrediente existe no estoque
	public boolean existe(String identificador) {
		boolean resposta = false;
		for (int contador = (this.contadorLista - 1); contador >= 0; contador--)
			if (this.estoque[contador].getIdentificador().equals(identificador))
				resposta = true;
		return resposta;
	}

}