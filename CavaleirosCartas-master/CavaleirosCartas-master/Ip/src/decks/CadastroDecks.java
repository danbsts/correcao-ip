package decks;

import excecoes.*;

public class CadastroDecks {
	private RepositorioDecks repDeck;

	public CadastroDecks(RepositorioDecks rep) {
		this.repDeck = rep;
	}
	/*
	 * Método cadastrar, verifica se o objeto já existe no repositorio se não existe
	 * ela irá chamar o método inserir do repositorio
	 */
	public void cadastrar(Deck deck) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException{
		if(repDeck.existe(deck.getId())) {
			throw new IdJaCadastradoException();
		}else {
			repDeck.inserir(deck);
		}
	}
	/*
	 * Método retirar, verifica se o objeto existe, pois se não exister não tem como
	 * removê-lo
	 */
	public void retirar(int id) throws NaoEncontradoException{
		if(!repDeck.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			repDeck.remover(id);
		}
	}
	/*
	 * Método buscar, verifica se o objeto existe, e caso exista chamará o método
	 * procurar do repositorio que retorna o objeto com o ID passado pelo paramentro
	 */
	public Deck buscar(int id) throws NaoEncontradoException{
		if(!repDeck.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			return repDeck.procurar(id);
		}
	}
	/*
	 * Método retificar, verificar se o objeto com o ID passado existe, caso exista
	 * ele substituirá esse objeto por um novo passado como parametro
	 */
	public void retificar(int id,Deck deck) throws NaoEncontradoException {
		if(repDeck.existe(id)) {
			repDeck.atualizar(id, deck);
		}else {
			throw new NaoEncontradoException();
		}
	}
	/*
	 * Método presente, literalmente verifica a presença de um objeto, retornando
	 * true caso o objeto exista e false caso não exista
	 */
	public boolean presente(int id) {
		return repDeck.existe(id);
	}
}
