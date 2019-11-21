package cliente;

import pessoa.Pessoa;
import venda.RepositorioVenda;

public class Cliente extends Pessoa {
    private double desconto=0.9;
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		desconto = 0.9;
	}

	public void gerarBonus() {
	 this.setBonus(getBonus()+1);
	 
		if(this.getBonus()>2) {		
			this.setBonus(0);
		}	
	}

	public double getDesconto() {
		return desconto;
	}

}
