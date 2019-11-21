package funcionarios;

public class Dono extends Funcionario{
	private String CNPJ;
	
	public Dono (String login, String senha, String nome, String endereco, String dataDeNascimento,
			String cpf, String rg, String CNPJ) {
		super(login, senha, nome, endereco, dataDeNascimento,cpf, rg);
		this.CNPJ = CNPJ;
	}

	

}