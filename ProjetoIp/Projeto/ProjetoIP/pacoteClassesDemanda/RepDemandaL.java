package pacoteClassesDemanda;

import pacoteClassesPessoa.*;
import pacoteExcecoes.EDException;
import pacoteExcecoes.NDException;

public class RepDemandaL implements RepositorioDemanda {

	private Demanda demanda;
	private RepDemandaL proximo;
	private int codigo = 1;

	public RepDemandaL() {
		this.demanda = null;
		this.proximo = null;

	}

	@Override
	public Demanda inserir(Demanda demanda) throws EDException {
		if (!this.existe(demanda)) {
			if (this.demanda == null) {
				demanda.setCodigo(codigo);
				this.demanda = demanda;
				this.proximo = new RepDemandaL();
				this.proximo.codigo = this.codigo + 1;
			} else {
				this.proximo.inserir(demanda);
			}
		} else {
			throw new EDException();
		}
		return demanda;
	}

	@Override
	public void remover(int codigo) throws NDException {
		if (this.demanda != null) {
			if (this.demanda.getCodigo() == (demanda.getCodigo())) {
				this.demanda = this.proximo.demanda;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(codigo);
			}
		} else {
			throw new NDException();
		}
	}

	@Override
	public void atualizar(int codigo, Demanda nova) throws NDException {
		if (this.demanda != null) {
			if (this.demanda.getCodigo() == (demanda.getCodigo())) {
				this.demanda = nova;
			} else {
				this.proximo.atualizar(codigo, nova);
			}
		} else {
			throw new NDException();
		}

	}

	@Override
	public Demanda procurarDemanda(int codigo) throws NDException {
		Demanda aux = null;
		if (this.demanda != null) {
			if (this.demanda.getCodigo() == codigo) {
				aux = this.demanda;
			} else {
				aux = this.proximo.procurarDemanda(codigo);
			}
		} else {
			throw new NDException();
		}
		return aux;
	}

	@Override
	public boolean existe(Demanda demanda) { 
		/* uma pessoa pode ter varias demandas, até porque varios problemas ocorrem no dia a dia;
		 * mas nao pode a mesma pessoa, cadastrar o mesmo problema duas vezes, porque estaria tirando a vaga de outra pessoa;
		 */
		boolean existe = false;
		if (this.demanda == null)
			return false;
		if (this.demanda.getArea().equals(demanda.getArea()) && this.demanda.getPessoa().getDocumento().equals(demanda.getPessoa().getDocumento())) {
			existe = true;
		} else if (this.proximo != null) {
			existe = this.proximo.existe(demanda);
		} else {
			existe = false;
		}
		return existe;
	}

}
