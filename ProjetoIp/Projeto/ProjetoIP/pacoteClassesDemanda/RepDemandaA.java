package pacoteClassesDemanda;
import pacoteExcecoes.EDException;
import pacoteExcecoes.NDException;

public class RepDemandaA implements RepositorioDemanda {

	private Demanda[] demandaArray;
	private int indice;

	public RepDemandaA() {
		demandaArray = new Demanda[100];
		indice = 0;
	}

	@Override
	public Demanda inserir(Demanda demanda) throws EDException {
		if (!this.existe(demanda) && this.indice < this.demandaArray.length) {
			demanda.setCodigo(indice + 1);//codigo usado depois (fachada)
			this.demandaArray[indice] = demanda;
			this.indice++;
			
		} else {
			throw new EDException();
		}
		return demanda; //retorna demanda pra poder ter o codigo, facilitar a procura do cliente 

	}

	@Override
	public void remover(int codigo) throws NDException {
		boolean encontrado = false;
		for (int a = 0; a <= indice && (!encontrado && this.demandaArray[a] != null); a++) {
			if (this.demandaArray[a].getCodigo() == codigo) {
				for (int k = a; k <= indice - 1; k++) {
					this.demandaArray[k] = this.demandaArray[k + 1];
				}
				encontrado = true;
				indice--;
			}
		}
		if (!encontrado) {
			throw new NDException();
		}
	}

	@Override
	public void atualizar(int codigo, Demanda nova) throws NDException {
		boolean valido = procurarDemanda(codigo).igual(nova);// compara codigo
		
		if (valido) {
			int a = this.indice(procurarDemanda(codigo));
			this.demandaArray[a] = nova;
		} else {
			throw new NDException();
		}
	}

	public int indice(Demanda demanda) throws NDException {
		int ind = 0;
		boolean tem = false;

		for (int b = 0; b < indice && !tem; b++) {
			if (this.demandaArray[b].getCodigo()==(demanda.getCodigo())) {
				tem = true;
				ind = b;
			}
		}
		if (!tem) {
			throw new NDException();
		}

		return ind;
	}

	@Override
	public Demanda procurarDemanda(int codigo) throws NDException {
		int indice2 = 0;
		boolean encontrou = false;
		for (int n = 0; n <= indice && !encontrou; n++) {
			if (this.demandaArray[n].getCodigo()== codigo) {
				encontrou = true;
				indice2 = n;
			}
		}
		if (!encontrou) {
			throw new NDException();
		}
		return this.demandaArray[indice2];
	}

	@Override
	public boolean existe(Demanda demanda) {
		boolean resposta = false;
		for (int a = 0; a < indice && !resposta; a++) {
			if (this.demandaArray[a].getCodigo() == demanda.getCodigo()) {
				resposta = true;
			}
		}
		return resposta;
	}


}
