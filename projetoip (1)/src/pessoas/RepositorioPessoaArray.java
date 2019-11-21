package pessoas;
public class RepositorioPessoaArray implements Repositorio{
	private Pessoa[] pessoas;
	private int indice;
	public RepositorioPessoaArray(int indice) {
		pessoas = new Pessoa[indice];
		indice = 0;
	}
	public boolean cadastrar(Pessoa pessoa) throws PessoaJaExistenteException {
		if (this.indice == (this.pessoas.length)) {
			Pessoa[]aux = new Pessoa [this.indice];
			aux = this.pessoas;
			this.indice++;
			this.pessoas = new Pessoa [this.indice];
			for (int i = 0; i < (this.indice-1); i++) {
				this.pessoas[i] = aux[i];
			}
			this.pessoas[this.indice-1] = pessoa;
		} else {
			this.pessoas[this.indice] = pessoa;
			this.indice++;
		}
		return true;
	}
	public boolean remover(String cpf) throws PessoaNaoEncontradaException {
		int i = this.getIndice(cpf);
		if (i == this.indice) {
			throw new PessoaNaoEncontradaException();
		} else {
			this.indice--;
			this.pessoas[i] = this.pessoas[this.indice];
			this.pessoas[this.indice] = null;
		}
		return true;
	}
	public boolean atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		int i = this.getIndice(pessoa.getCpf());
		if (i == this.indice) {
			throw new PessoaNaoEncontradaException();
		} else {
			this.pessoas[i] = pessoa;
		}
		return false;
	}
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		Pessoa procurado = null;
		int i = this.getIndice(cpf);
		if (i == this.indice) {
			throw new PessoaNaoEncontradaException();
		} else {
			procurado = this.pessoas[i];
		}
		return procurado;
	}
	public boolean existe(String cpf){
		boolean result=false;			
			for (int i = 0; i < pessoas.length; i++) {
				if(pessoas[i]==null) {
				return result;	
				}
				if(pessoas[i].getCpf().equals(cpf)) {
					result=true;
				}
			}
		return result;
	}
	public int getIndice(String cpf) throws PessoaNaoEncontradaException{
		String aux;
		int i = 0;
		while (i < this.indice) {
			aux = pessoas[i].getCpf();		
			if (aux.equals(cpf)) {
				return i;
			} else {
				i++;
			}
		} 
		throw new PessoaNaoEncontradaException();
	}
}