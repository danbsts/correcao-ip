package funcionarios;


public class Garcom extends Funcionario{
	protected double salario;
	protected double comissao;
	
	public Garcom (String login, String senha, String nome, String endereco, String dataDeNascimento,
			String cpf, String rg, double salario) {
		super(login, senha, nome, endereco, dataDeNascimento,cpf, rg);
		this.salario = salario;
		this.comissao = 0;
	}
	
	public void calcularComissao(double mesasAtendidas) {
		this.comissao = (this.salario*0.01)*mesasAtendidas; 
	}
	
}
