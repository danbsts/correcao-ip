package cliente;

public class ClienteExisteException extends Exception {
	private String nome;
	private String cpf;

	public ClienteExisteException(String nome,String cpf) {
		super("Cliente já cadastrado");
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
