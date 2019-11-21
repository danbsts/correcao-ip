package pacoteClassesPessoa;

import pacoteExcecoes.NOException;
import pacoteExcecoes.UFException;
import pacoteExcecoes.UIException;

public class NegocioPessoa {

	RepositorioPessoa people;

	public NegocioPessoa(int a) throws NOException {
		if (a == 1) {
			people = new RepPessoaL();
		} else if (a == 2) {
			people = new RepPessoaA();
		} else {
			throw new NOException();
		}
	}

	public void cadastrar(Pessoa pessoa) throws UFException {
		this.people.inserir(pessoa);
	}

	public boolean existe(String documento) {
		return this.people.existe(documento);
	}

	public void atualizar(Pessoa pessoa, Pessoa mudar) throws UIException{
		this.people.atualizar(pessoa, mudar);
	}

	public void deletar(Pessoa pessoa) throws UIException{
		this.people.remover(pessoa);
	}

	public Pessoa procurarPessoa(String documento) throws UIException{
		return this.people.procurarPessoa(documento);
	}
}
