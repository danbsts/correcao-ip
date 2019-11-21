package excecoes;

public class CartaNaoCadastradaException extends Exception{
	public CartaNaoCadastradaException() {

		super("Alguma carta do deck não foi cadastrada");

	}
}