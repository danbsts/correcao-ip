package pessoa;
public abstract class PessoaAbstract {
	private String nome;
	private String cpf;
	private String telefone;
	public PessoaAbstract (String nome, String cpf, String telefone) {
       this.nome = nome;
       this.cpf = cpf;
       this.telefone = telefone;
	}
	public abstract double gerarbonus (double valor);
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
