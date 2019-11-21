package servicoDeEntrega;

public class DIException extends Exception{
	private int distancia;

	public DIException(int distancia) {
		super ("Distancia fornecida e invalida!");
		this.distancia=distancia;	
	}
	public int getDistancia() {
		return distancia;
	}

}
