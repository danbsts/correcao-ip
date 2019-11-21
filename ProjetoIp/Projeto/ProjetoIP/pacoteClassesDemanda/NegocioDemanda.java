package pacoteClassesDemanda;

import pacoteExcecoes.EDException;
import pacoteExcecoes.NDException;
import pacoteExcecoes.NOException;

public class NegocioDemanda {

	RepositorioDemanda demandas;
	
	public NegocioDemanda(int a) throws NOException {
		if (a == 1) {
			demandas = new RepDemandaL();
		} else if (a == 2) {
			demandas= new RepDemandaA();
		} else {
			throw new NOException();
		}
	}
	public Demanda cadastrar(Demanda demanda) throws EDException{
		return this.demandas.inserir(demanda);
	}

	public void deletar(int codigo) throws NDException{
		this.demandas.remover(codigo);
	}

	public void atualizarDemanda(int codigo, Demanda nova) throws NDException{
		this.demandas.atualizar(codigo, nova);
	}

	public Demanda procurarDemanda(int codigo) throws NDException{
		return this.demandas.procurarDemanda(codigo);
	}
	
	public boolean existe (Demanda demanda) {
		return this.demandas.existe(demanda);
	}
}
