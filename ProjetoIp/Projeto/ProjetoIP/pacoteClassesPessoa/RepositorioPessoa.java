package pacoteClassesPessoa;

import pacoteExcecoes.UFException;
import pacoteExcecoes.UIException;

public interface RepositorioPessoa {

	public void inserir(Pessoa pessoa) throws UFException;

	public boolean existe(String documento); // so pra dizer se existe ou nao

	public void atualizar(Pessoa pessoa, Pessoa mudar) throws UIException;

	public void remover(Pessoa pessoa) throws UIException;

	public Pessoa procurarPessoa(String documento) throws UIException;  // esse retorna pessoa
}
