package pessoas;
public class RepositorioPessoaLista implements Repositorio{
	private Pessoa pessoa;
	private RepositorioPessoaLista proximo;
	public RepositorioPessoaLista(){}
	public boolean cadastrar(Pessoa pessoapar) throws PessoaJaExistenteException {
		if (this.pessoa == null) {
			this.pessoa = pessoapar;
			this.proximo = new RepositorioPessoaLista();
		} else if(pessoa.getCpf().equals(pessoapar.getCpf())) {
			throw new PessoaJaExistenteException();
		}else{
			this.proximo.cadastrar(pessoapar);
		}
		return true;
	}
	public boolean remover(String cpf) throws PessoaNaoEncontradaException {
		if (this.pessoa == null) {
			throw new PessoaNaoEncontradaException();
		} else {
			if (this.pessoa.getCpf().equals(cpf)) {
				this.pessoa = this.proximo.pessoa;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(cpf);
			}
			return true;
		}
	}
	public boolean atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		if (this.pessoa == null) {
			throw new PessoaNaoEncontradaException();
		} else {
			if (this.pessoa.getCpf().equals(pessoa.getCpf())) {
				this.pessoa = pessoa;
			} else {
				this.proximo.atualizar(pessoa);
			}
			return true;
		}
	}
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		if (this.pessoa == null) {
			throw new PessoaNaoEncontradaException();
		} else {
			if (this.pessoa.getCpf().equals(cpf)) {
				return this.pessoa;
			} else {
				return this.proximo.procurar(cpf);
			}
		}
	}
	public boolean existe(String cpf){
		if (this.pessoa == null) {
			return false;
		} else {
			if (this.pessoa.getCpf().equals(cpf)) {
				return true;
			} else {
				return this.proximo.existe(cpf);
			}
		}
	}
}
