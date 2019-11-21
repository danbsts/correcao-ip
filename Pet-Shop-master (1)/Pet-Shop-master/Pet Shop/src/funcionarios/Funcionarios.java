package funcionarios;

import pessoa.PessoaAbstract;

public class Funcionarios extends PessoaAbstract {
	private String codigo;
	private double salario;
	
	public Funcionarios(String nome, String cpf, String telefone, String codigo, double salario) {
		super(nome, cpf, telefone);
		this.codigo = codigo;
		this.salario = salario;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double gerarbonus(double valor) {
		return valor * 0.02;
	}
		
}
