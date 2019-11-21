package ingredientes;

public class RepositorioIngredientesLista implements RepositorioIngredientes {
	private Ingrediente ingrediente;
	private RepositorioIngredientesLista proximo;

	public RepositorioIngredientesLista() {
		this.ingrediente = null;
		this.proximo = null;
	}

	// Adiciona algum ingrediente ao Estoque
	public void inserir(Ingrediente ingrediente) {
		if (this.ingrediente == null) {
			this.ingrediente = ingrediente;
			this.proximo = new RepositorioIngredientesLista();
		} else
			this.proximo.inserir(ingrediente);
	}

	// Remove algum ingrediente ao Estoque
	public void remover(String identificador) {
		if (this.ingrediente.getIdentificador().equals(identificador)) {
			this.ingrediente = this.proximo.ingrediente;
			this.proximo = this.proximo.proximo;
		} else
			this.proximo.remover(identificador);
	}

	// Atualiza os atributos de um ingrediente no estoque
	public void atualizar(Ingrediente ingrediente) {
		if (this.ingrediente.getIdentificador().equals(ingrediente.getIdentificador())) {
			this.ingrediente = ingrediente;
		} else
			this.proximo.atualizar(ingrediente);
	}
	
	// Retorna o status de um ingrediente
	public Ingrediente procurar(String identificador) {
		if (this.ingrediente.getIdentificador().equals(identificador)) {
			return this.ingrediente; 
		} else
			return this.proximo.procurar(identificador);
	}

	// Analisa se algum ingrediente existe no estoque
		public boolean existe(String identificador) {
			if (this.ingrediente == null)
				return false;
			else if (this.ingrediente.getIdentificador().equals(identificador))
				return true;
			else
				return this.proximo.existe(identificador);
		}
}
