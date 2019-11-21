package funcionarios;

public abstract class Funcionario {
	protected String login;
	protected String senha;
	protected String nome;
	protected String endereco;
	protected String dataDeNascimento;
	protected String cpf;
	protected String rg;

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public String getFuncao() {
		//Garcom, Gerente, Dono
		if(this instanceof Garcom)
		return "Garcom";
		else if(this instanceof Gerente)
		return "Gerente";
		else if(this instanceof Dono)
		return "Dono";
		else
		return "Funcionario";
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

// construtor de classe
	Funcionario( // parametros:
			String login, String senha, String nome, String endereco, String dataDeNascimento,
			String cpf, String rg) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.rg = rg;
	}

//getTudo
	public String getDados() {
		String res = "";
		String hiddenLogin = "";
		String hiddenSenha = "";
		for(int i = 0; i<this.login.length(); i++) {
			hiddenLogin += "*";
		}
		for(int i = 0; i<this.senha.length(); i++) {
			hiddenSenha += "*";
		}
				
		res += "Login: " + hiddenLogin + "\n";
		res += "Senha: "+ hiddenSenha +"\n";
		res += "Nome Completo: " + this.nome + "\n";
		res += "Endereço: " + this.endereco + "\n";
		res += "Data De Nascimento: " + this.dataDeNascimento + "\n";
		res += "CPF: " + this.cpf + "\n";
		res += "RG: " + this.rg + "\n";
		res += "------------------------";
		return res;
	}

}
