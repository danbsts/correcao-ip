package pacoteClassesDemanda;

import pacoteClassesPessoa.*;

public class Demanda {
	private Pessoa pessoa;
	private String area;
	private String resumo;//assunto tratado, como : batida de carro, roubo.
	private int codigo;
	
	public Demanda(Pessoa pessoa, String area, String resumo) {
		this.pessoa = pessoa;
		this.area = area;
		this.resumo = resumo;

	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo (int codigo) {
		this.codigo = codigo;
	}
	public boolean igual(Demanda demanda) { // analisa se os dois codigos sao iguais pra mudar tudo 
		if (this.codigo == demanda.codigo) {
			return true;
		} else {
			return false;
		}
	}

}
