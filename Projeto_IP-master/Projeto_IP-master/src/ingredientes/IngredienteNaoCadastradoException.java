package ingredientes;

public class IngredienteNaoCadastradoException extends Exception{

	public IngredienteNaoCadastradoException() {
		super("Nao existe nenhum ingrediente cadastrado com esse identificador no sistema");
	}
}