package entregador;
import Pessoa.Pessoa;;

public class Entregador extends Pessoa {
	private String transporte;
	private double precoPorDistancia;
	
	 public Entregador(String nome, String cpf, String contato, String transporte, double precoPorDistancia) {
	        super(nome, cpf, contato);
	        this.transporte=transporte;
	        this.precoPorDistancia=precoPorDistancia;
	    }
	
	public double getPrecoPorDistancia() {
		return precoPorDistancia;
	}
	public void setPrecoPorDistancia(double precoPorDistancia) {
		this.precoPorDistancia = precoPorDistancia;
	}
	public String getTransporte() {
		return transporte;
	}
	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}
	
//oi :)//
}