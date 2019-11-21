package extradecks;

import excecoes.*;

public interface RepositorioExtraDecks {
	public void inserir(ExtraDeck extra) throws ArrayCheioException;
	public void remover(int id) throws NaoEncontradoException;
	public ExtraDeck procurar(int id) throws NaoEncontradoException;
	public void atualizar(int id, ExtraDeck extra) throws NaoEncontradoException;
	public boolean existe(int id);
}