package ingredientes;

public class IngredienteJaCadastradoException extends Exception{

	public IngredienteJaCadastradoException(){
		super("Esse ingrediente ja esta cadastrado no estoque");
	}
}