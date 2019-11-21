package pacoteClassesPessoa;
//Testado
//pessoa procura tudo por documento, que é a unica coisa que nao pode ser mudada (todo mundo so tem um cpf ou cnpj)
import pacoteExcecoes.UFException;
import pacoteExcecoes.UIException;

public class RepPessoaA implements RepositorioPessoa {
	private Pessoa[] pessoaArray;
	private int indice;

	public RepPessoaA() {
		pessoaArray = new Pessoa[100];
		indice = 0;
	}

	@Override
	public void inserir(Pessoa pessoa) throws UFException {
		if (!this.existe(pessoa.getDocumento()) && this.indice < this.pessoaArray.length) {
			this.pessoaArray[indice] = pessoa;
			this.indice++;
		} else {
			throw new UFException();
		}

	}

	@Override
	public boolean existe(String documento) {
		boolean resposta = false;
		for (int a = 0; a < indice && !resposta; a++) {
			if (this.pessoaArray[a].getDocumento().equals(documento)) {
				resposta = true;
			}
		}
		return resposta;
	}

	@Override
	public void atualizar(Pessoa pessoa, Pessoa mudar) throws UIException {
		boolean valido = pessoa.igual(mudar);
		

		if (valido) {
			int a = this.indice(pessoa.getDocumento());
			this.pessoaArray[a] = mudar;
		} else {
			throw new UIException();
		}

	}

	@Override
	public void remover(Pessoa pessoa) throws UIException {
		boolean encontrado = false;
		for (int a = 0; a <= indice && (!encontrado && this.pessoaArray[a] != null); a++) {
			if (this.pessoaArray[a].equals(pessoa)) {
				for (int k = a; k <= indice - 1; k++) {
					this.pessoaArray[k] = this.pessoaArray[k + 1];
				}
				encontrado = true;
				indice--;
			}

		}
		if (!encontrado) {
			throw new UIException();
		}
	}

	public int indice(String documento) throws UIException { //metodo so de array, pra poder atualizar
		int ind = 0;
		boolean tem = false;

		for (int b = 0; b < indice && !tem; b++) {
			if (this.pessoaArray[b].getDocumento().equals(documento)) {
				tem = true;
				ind = b;
			}
		}
		if (!tem) {
			throw new UIException();
		}

		return ind;
	}

	public Pessoa procurarPessoa(String documento) throws UIException {
		int indice2 = 0;
		boolean encontrou = false;
		for (int n = 0; n <= indice && !encontrou; n++) {
			if (this.pessoaArray[n].getDocumento().equals(documento)) {
				encontrou = true;
				indice2 = n;
			}
		}
		if (!encontrou) {
			throw new UIException();
		}
		return this.pessoaArray[indice2];
	}

}
