package servicoDeEntrega;

public class IdentException extends Exception{
	private int identificador;

	public IdentException(int identificador) {
		super ("Identificador fornecido e invalido!");
		this.identificador=identificador;	
	}
	public int getIdentificador() {
		return identificador;
	}

}
