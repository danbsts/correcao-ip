package cliente;

public class ClienteNExisteException extends Exception {
	private String nome;
	private String cpf;

	public ClienteNExisteException(String nome, String cpf) {
		super("Cliente não cadastrado");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getcpf() {
		return cpf;
	}
}
