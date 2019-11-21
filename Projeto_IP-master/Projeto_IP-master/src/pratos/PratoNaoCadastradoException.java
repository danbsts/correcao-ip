package pratos;

public class PratoNaoCadastradoException extends Exception {
	public PratoNaoCadastradoException(){
		super("Esse prato nao consta no cardapio");
	}
}
