package duelistas;

import excecoes.*;

public class CadastroDuelistas {
	private RepositorioDuelistas repDuelista;

	public CadastroDuelistas(RepositorioDuelistas rep) {
		this.repDuelista = rep;
	}
	/*
	 * Método cadastrar, verifica se o objeto já existe no repositorio se não existe
	 * ela irá chamar o método inserir do repositorio
	 */
	public void cadastrar(Duelista duelista) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException{
		if(repDuelista.existe(duelista.getId())) {
			throw new IdJaCadastradoException();
		}else {
			repDuelista.inserir(duelista);
		}
	}
	/*
	 * Método retirar, verifica se o objeto existe, pois se não exister não tem como
	 * removê-lo
	 */
	public void retirar(int id) throws NaoEncontradoException {
		if(!repDuelista.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			repDuelista.remover(id);
		}
	}
	/*
	 * Método buscar, verifica se o objeto existe, e caso exista chamará o método
	 * procurar do repositorio que retorna o objeto com o ID passado pelo paramentro
	 */
	public Duelista buscar(int id) throws NaoEncontradoException{
		if(!repDuelista.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			return repDuelista.procurar(id);
		}
	}
	/*
	 * Método retificar, verificar se o objeto com o ID passado existe, caso exista
	 * ele substituirá esse objeto por um novo passado como parametro
	 */
	public void retificar(int id,Duelista duelista) throws NaoEncontradoException {
		if(repDuelista.existe(id)) {
			repDuelista.atualizar(id, duelista);
		}else {
			throw new NaoEncontradoException();
		}
	}
	/*
	 * Método presente, literalmente verifica a presença de um objeto, retornando
	 * true caso o objeto exista e false caso não exista
	 */
	public boolean presente(int id){
		return repDuelista.existe(id);
	}
}

