package pratos;

public class PratoJaCadastradoException extends Exception {

	public PratoJaCadastradoException(){
		super("Esse prato ja consta no nosso cardapio");
	}
	
	
}
