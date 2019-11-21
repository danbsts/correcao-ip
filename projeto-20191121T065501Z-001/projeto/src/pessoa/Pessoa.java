package pessoa;

import venda.RepositorioVenda;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	/* private RepositorioVendas historico; */
	private int bonus;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
//this.historico=null;//
		
	}

	public String getNome() {
		return nome;
	}

	/*
	 * public RepositorioVendas getHistorico() { return historico; }
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public abstract void gerarBonus();

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
