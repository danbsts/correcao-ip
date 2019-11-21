package pessoas;
public class Cliente extends Pessoa {
	private double desconto;
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public Cliente(String cpf, String nome, double desconto) {
		super(cpf, nome);
		this.desconto = desconto;
	}
}