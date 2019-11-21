package ingredientes;

public interface RepositorioIngredientes {
	//Metodos basicos
	void inserir(Ingrediente ingrediente);
	void remover(String identificador);
	void atualizar(Ingrediente ingrediente);
	Ingrediente procurar(String identificador);
	boolean existe(String identificador);
}