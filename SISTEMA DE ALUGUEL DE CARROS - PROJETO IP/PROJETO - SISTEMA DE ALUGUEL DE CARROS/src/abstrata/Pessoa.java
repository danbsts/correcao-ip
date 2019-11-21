package abstrata;

public abstract class Pessoa {
	protected String nome;
	private String cpf;
	private String telefone;
	
	public Pessoa(String nome, String cpf, String telefone) {
		this.nome=nome;
		this.cpf=cpf;
		this.telefone=telefone;
	}
	
	public abstract String getNome();
	
	
	public String getCpf() {
		return cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
    public void setCpf(String cpf) {
    	this.cpf=cpf;
    }
    public void setTelefone(String telefone) {
    	this.telefone=telefone;
    }

}
