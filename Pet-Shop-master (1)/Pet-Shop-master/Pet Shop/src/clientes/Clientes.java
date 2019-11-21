package clientes;

import pessoa.PessoaAbstract;

public class Clientes extends PessoaAbstract {
	
	private double credito;

	public Clientes (String nome, String cpf, String telefone) { 
		super (nome,cpf,telefone);
		this.credito = 0;	
	}

	public double gerarbonus(double valor) {
		return valor * 0.1;
	}


	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}



	


}
