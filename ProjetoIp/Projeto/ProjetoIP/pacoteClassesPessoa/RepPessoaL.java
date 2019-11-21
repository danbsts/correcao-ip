package pacoteClassesPessoa;
//TESTEI ESSA PORRAAAAA

import java.util.Scanner;

import pacoteExcecoes.UFException;
import pacoteExcecoes.UIException;

public class RepPessoaL implements RepositorioPessoa {

	private Pessoa pessoa;
	private RepPessoaL proximo;

	public RepPessoaL() {
		this.pessoa = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Pessoa pessoa) throws UFException { // provavelmente na classe negocio a exceção
		if (!this.existe(pessoa.getDocumento())) {
			if (this.proximo == null) {
				this.pessoa = pessoa;
				this.proximo = new RepPessoaL();
			} else {
				this.proximo.inserir(pessoa);
			}
		} else {
			throw new UFException();
		}
	}

	@Override
	public boolean existe(String documento) {
		boolean resposta = false;
		if(this.pessoa == null)
			return false;
		if (this.pessoa.getDocumento().equals(documento)) {
			resposta = true;
		} else if (this.proximo != null) {
			resposta = this.proximo.existe(documento);
		} else {
			resposta = false;
		}
		return resposta;

	}

	@Override
	public void atualizar(Pessoa pessoa, Pessoa mudar) throws UIException {
		if (this.pessoa != null) {
			if (this.pessoa.igual(pessoa)) {
				this.pessoa = mudar;
			} else {
				this.proximo.atualizar(pessoa, mudar);
			}
		} else {
			throw new UIException();
		}
	}

	@Override
	public void remover(Pessoa pessoa) throws UIException {
		if (this.pessoa != null) {
			if (this.pessoa.getDocumento().equals(pessoa.getDocumento())) {
				this.pessoa = this.proximo.pessoa;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(pessoa);
			}
		} else {
			throw new UIException();
		}

	}

	public Pessoa procurarPessoa(String documento) throws UIException {
		Pessoa aux = null;
		if (this.pessoa != null) {
			if (this.pessoa.getDocumento().equals(documento)) {
				aux = this.pessoa;
			} else {
				aux = this.proximo.procurarPessoa(documento);
			}
		} else {
			throw new UIException();
		}
		return aux;
	}
	
}
