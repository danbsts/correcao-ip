package pessoas;
public abstract class Pessoa {
	//Definiros identificadors, gerar os get's e set's, e construtor(es).
	private String cpf;
	private String nome;
   protected Pessoa(String cpf, String nome){
		setCpf(cpf);
		setNome(nome);
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
