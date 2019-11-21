
package ingredientes;

import pratos.Prato;

public class CadastroIngredientes {
	private RepositorioIngredientes estoque;

	public CadastroIngredientes(RepositorioIngredientes rep) {
		this.estoque = rep;
	}

	// Insere um ingrediente no Estoque
	public void inserir(Ingrediente ingrediente) throws IngredienteJaCadastradoException {
		if (!this.estoque.existe(ingrediente.getIdentificador()))
			this.estoque.inserir(ingrediente);
		else
			throw new IngredienteJaCadastradoException();
	}

	// Remove um ingrediente no Estoque
	public void remover(String identificador) throws IngredienteNaoCadastradoException {
		if (this.estoque.existe(identificador))
			this.estoque.remover(identificador);
		else
			throw new IngredienteNaoCadastradoException();
	}

	// Atualiza o status de um ingrediente do Estoque
	public void atualizar(Ingrediente ingrediente) throws IngredienteNaoCadastradoException {
		if (this.estoque.existe(ingrediente.getIdentificador()))
			this.estoque.atualizar(ingrediente);
		else
			throw new IngredienteNaoCadastradoException();
	}

	// Procura um ingrediente no estoque
	public Ingrediente procurar(String identificador) throws IngredienteNaoCadastradoException {
		if (this.estoque.existe(identificador))
			return this.estoque.procurar(identificador);
		else
			throw new IngredienteNaoCadastradoException();
	}
	// Analisa se um ingrediente existe ou nao no estoque
	public boolean existe(Ingrediente ingrediente) {
		String identificador = ingrediente.getIdentificador();
		if(estoque.existe(identificador)) {
			return true;
		} else {
			return false;
		}
	}
	//Retorna todos os ingredientes do estoque
	public RepositorioIngredientes getIngredientes() {
		return this.estoque;
	}
	
}