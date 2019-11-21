package Cliente;
import Pessoa.Pessoa;

public class Cliente extends Pessoa{

	private String especie;
	
	public Cliente(String nome, String cpf, String especie, String contato) {
		super(nome, cpf, contato);
		this.especie = especie;
	
}
	public String getEspecie() { 
		return especie; 
		}
    
	public void setEspecie(String especie) {
		this.especie = especie;
	}
}
