package pessoas;
public class Garcom extends Pessoa {
	private boolean disponivel;
	private double salario;
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Garcom(String cpf, String nome, boolean disponivel, double salario) {
		super(cpf, nome);
		this.disponivel = disponivel;
		this.salario = salario;
	}
}