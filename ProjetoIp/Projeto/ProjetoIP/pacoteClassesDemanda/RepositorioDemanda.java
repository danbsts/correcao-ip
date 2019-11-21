package pacoteClassesDemanda;

import pacoteExcecoes.EDException;
import pacoteExcecoes.NDException;

public interface RepositorioDemanda {

	public Demanda inserir(Demanda demanda) throws EDException;

	public void remover(int codigo) throws NDException;

	public void atualizar(int codigo, Demanda nova) throws NDException;

	public Demanda procurarDemanda(int codigo) throws NDException;
	
	public boolean existe (Demanda demanda);
}
