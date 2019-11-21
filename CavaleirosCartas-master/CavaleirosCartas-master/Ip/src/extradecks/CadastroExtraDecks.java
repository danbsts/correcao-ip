package extradecks;

import excecoes.*;

public class CadastroExtraDecks {
	private RepositorioExtraDecks repExtraDeck;

	public CadastroExtraDecks(RepositorioExtraDecks rep) {
		this.repExtraDeck = rep;
	}
	/*
	 * Método cadastrar, verifica se o objeto já existe no repositorio se não existe
	 * ela irá chamar o método inserir do repositorio
	 */
	public void cadastrar(ExtraDeck extradeck) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException{
		if(repExtraDeck.existe(extradeck.getId())) {
			throw new IdJaCadastradoException();
		}else {
			repExtraDeck.inserir(extradeck);
		}
	}
	/*
	 * Método retirar, verifica se o objeto existe, pois se não exister não tem como
	 * removê-lo
	 */
	public void retirar(int id) throws NaoEncontradoException {
		if(!repExtraDeck.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			repExtraDeck.remover(id);
		}
	}
	/*
	 * Método buscar, verifica se o objeto existe, e caso exista chamará o método
	 * procurar do repositorio que retorna o objeto com o ID passado pelo paramentro
	 */
	public ExtraDeck buscar(int id) throws NaoEncontradoException{
		if(!repExtraDeck.existe(id)) {
			throw new NaoEncontradoException();
		}else {
			return repExtraDeck.procurar(id);
		}
	}
	/*
	 * Método retificar, verificar se o objeto com o ID passado existe, caso exista
	 * ele substituirá esse objeto por um novo passado como parametro
	 */
	public void retificar(int id,ExtraDeck extradeck) throws NaoEncontradoException {
		if(repExtraDeck.existe(id)) {
			repExtraDeck.atualizar(id, extradeck);
		}else {
			throw new NaoEncontradoException();
		}
	}
	/*
	 * Método presente, literalmente verifica a presença de um objeto, retornando
	 * true caso o objeto exista e false caso não exista
	 */
	public boolean presente(int id){
		return repExtraDeck.existe(id);
	}
}
