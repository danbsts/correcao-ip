package mercadoria;


public class RepositorioMercadoriaLista implements RepositorioMercadoria {
	private Mercadoria mercadoria;
	private RepositorioMercadoriaLista proximo;

	public RepositorioMercadoriaLista() {
		this.mercadoria = null;
		this.proximo = null;
	}

	public void inserir(Mercadoria mercadoria) {
		if (this.mercadoria == null) {
			this.mercadoria = mercadoria;
			this.proximo = new RepositorioMercadoriaLista();
		} else {
			this.proximo.inserir(mercadoria);

		}

	}

	public void remover(int id) throws MercadoriaNaoEncontradaException {
		Mercadoria encontrada = this.procurar(id);

		if (this.mercadoria != null) {
			if (this.mercadoria.equals(encontrada)) {
				this.mercadoria = this.proximo.mercadoria;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(id);
			}
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}
	}

	public boolean existe(int id) {
		if (this.mercadoria != null) {
			if (this.mercadoria.getId() == id) {
				return true;
			} else {
				return this.proximo.existe(id);
			}
		} else {
			return false;
		}
	}

	public void atualizar(Mercadoria mercadoria) throws MercadoriaNaoEncontradaException {
		if(this.mercadoria.getId()==mercadoria.getId()) {
			this.mercadoria=mercadoria;
		}
		else if(this.proximo!=null) {
			this.proximo.atualizar(mercadoria);
		}
		else {
			throw new MercadoriaNaoEncontradaException();	
		}
	}

	public Mercadoria procurar(int id) throws MercadoriaNaoEncontradaException {
		Mercadoria encontrada;
		encontrada = null;
		if (this.mercadoria != null) {
			if (this.mercadoria.getId() == id) {
				encontrada = this.mercadoria;
			} else {
				encontrada = this.proximo.procurar(id);
			}
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}
		return encontrada;
	}
}
