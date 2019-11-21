package funcionarios;

public class Gerente extends Garcom{
	
	public Gerente (String login, String senha, String nome, String endereco, String dataDeNascimento,
			String cpf, String rg, double salario) {
		super(login, senha, nome, endereco, dataDeNascimento,cpf, rg, salario);
	}
	
	public void calcularComissao(double mesasAtendidas) {
		this.comissao = (this.salario*0.02)*mesasAtendidas; 
	}

}
