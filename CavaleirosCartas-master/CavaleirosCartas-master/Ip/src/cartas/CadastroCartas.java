package cartas;

import excecoes.*;

public class CadastroCartas {
	private RepositorioCartas repCartas;

	public CadastroCartas(RepositorioCartas rep) {
		this.repCartas = rep;
	}

	/*
	 * Método cadastrar, verifica se o objeto já existe no repositorio se não existe
	 * ela irá chamar o método inserir do repositorio
	 */
	public void cadastrar(Carta carta) throws IdJaCadastradoException, ArrayCheioException, NaoEncontradoException {
		if (repCartas.existe(carta.getId())) {
			throw new IdJaCadastradoException();
		} else {
			repCartas.inserir(carta);
		}
	}

	/*
	 * Método retirar, verifica se o objeto existe, pois se não exister não tem como
	 * removê-lo
	 */
	public void retirar(int id) throws NaoEncontradoException {
		if (!repCartas.existe(id)) {
			throw new NaoEncontradoException();
		} else {
			repCartas.remover(id);
		}
	}

	/*
	 * Método buscar, verifica se o objeto existe, e caso exista chamará o método
	 * procurar do repositorio que retorna o objeto com o ID passado pelo paramentro
	 */
	public Carta buscar(int id) throws NaoEncontradoException {
		if (!repCartas.existe(id)) {
			throw new NaoEncontradoException();
		} else {
			return repCartas.procurar(id);
		}
	}

	/*
	 * Método retificar, verificar se o objeto com o ID passado existe, caso exista
	 * ele substituirá esse objeto por um novo passado como parametro
	 */
	public void retificar(int id, Carta carta) throws NaoEncontradoException {
		if (repCartas.existe(id)) {
			repCartas.atualizar(id, carta);
		} else {
			throw new NaoEncontradoException();
		}
	}

	/*
	 * Método presente, literalmente verifica a presença de um objeto, retornando
	 * true caso o objeto exista e false caso não exista
	 */
	public boolean presente(int id) {
		return repCartas.existe(id);
	}
}
