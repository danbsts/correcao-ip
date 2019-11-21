package funcionario;
import pessoa.Pessoa;
//Funcionário como classe que Herda Pesssoa
public class Funcionario extends Pessoa {
//Atributos Funcionário	
	private int comissao;
	private int nivel;
	private double salario;
	
	//Construtor Funcionario
	public Funcionario(String nome, String cpf,double salario) {
		super(nome, cpf);
		this.salario=salario;//igualei this.salario a salario pq o o salario vai ser colocado pelo usuario no main
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario=salario;
	}
	@Override
	public void gerarBonus() {

		this.setBonus(getBonus()+1);

		if(this.getBonus()>=10) {			
		this.setSalario(this.getSalario()+ 50);
		this.setBonus(0);
		}



	}}
