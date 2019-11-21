package pacoteClassesPessoa;

public class PessoaJuridica extends Pessoa {
	private String CNPJ;

	public PessoaJuridica(String nome, String zipcode, String telefone, String CNPJ) {
		super(nome, zipcode, telefone);
		this.CNPJ = CNPJ;
	}

	@Override
	public boolean igual(Pessoa pessoa) {
		PessoaJuridica p = (PessoaJuridica)pessoa;
		if (this.CNPJ == p.CNPJ)
			return true;
		else
			return false;

	}

	@Override
	public String getDocumento() {
		return this.CNPJ;
	}
}
