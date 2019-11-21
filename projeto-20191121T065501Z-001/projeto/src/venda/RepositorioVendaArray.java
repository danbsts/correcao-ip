package venda;

public class RepositorioVendaArray implements RepositorioVenda {
	private Venda[] repositorio;
	private int cont;

	public RepositorioVendaArray() {

		this.repositorio = new Venda[10];
		this.cont = 0;

		for (int i = 0; i < repositorio.length; i++) {
			repositorio[i] = null;
		}

	}

	public void inserir(Venda venda) {
		if (cont >= repositorio.length) {

			Venda[] aux = new Venda[repositorio.length*2];
			for (int i = 0; i < repositorio.length; i++) {
				aux[i] = repositorio[i];
			}
			this.repositorio = aux;
			inserir(venda);
		} else {
			repositorio[cont] = venda;
			cont++;
		}

	}

	public boolean existe(Venda venda) {
		boolean aux = false;

		for (int i = 0; i < repositorio.length && repositorio[i] != null && !aux; i++) {

			if (repositorio[i].equals(venda)) {
				aux = true;
			}

		}

		return aux;
	}

	public Venda buscar(int id) throws BuscaIdException {
		Venda aux = null;
		for (int i = 0; i < repositorio.length; i++) {
			if (repositorio[i]!=null) {
				if (repositorio[i].getId() == id) {
					aux = repositorio[i];
				}
			}			
		}
		if (aux == null) {
			BuscaIdException e = new BuscaIdException(id);
			throw e;
		}
		return aux;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	@Override
	public void atualizar(Venda vendaAntiga, Venda vendaAtualizada) throws VendaNaoEncontradaException {
		boolean executado = false;
		for (int i = 0; i < repositorio.length &&  !executado; i++) {
			if (repositorio[i].equals(vendaAntiga)) {
				repositorio[i] = vendaAtualizada;
				executado = true;
			}
		}
		if (!executado) {
			VendaNaoEncontradaException e = new VendaNaoEncontradaException(vendaAntiga);
			throw e;
		}

	}


	@Override
	public void remover(Venda venda) throws VendaNaoEncontradaException {
		if (existe(venda)) {
			int i;
			for ( i = 0; i < repositorio.length; i++) {

				if (repositorio[i].equals(venda)) {
					repositorio[i]=null;
					cont--;
					break;
				}

			}


			for (int j = i; j < repositorio.length; j++) {
				if (j==repositorio.length-1) {
					repositorio[i]=null;
				}
				else
				repositorio[j]=repositorio[j+1];

			}
		}
		else {

			VendaNaoEncontradaException e =new VendaNaoEncontradaException(venda);
			throw e;
		}




	}

}