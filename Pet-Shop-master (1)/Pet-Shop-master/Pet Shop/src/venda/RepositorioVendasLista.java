package venda;

public class RepositorioVendasLista implements RepositorioVendas  {
	
	private Vendas venda;
	private RepositorioVendasLista proximo;

	@Override
	public void remover(String id) 
			throws VendaNaoEncontradaException {
		Vendas encontrado = this.procurar(id);
		if (this.venda != null) {
			if (this.venda.equals(encontrado)) {
				this.venda = this.proximo.venda;
				this.proximo = this.proximo.proximo;
			} else this.proximo.remover(id);
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
	}
	
	@Override
	public void inserir (Vendas venda) {
		//inicializando
		if (this.venda == null) {
			this.venda = venda;
			this.proximo = new RepositorioVendasLista();
		} else this.proximo.inserir(venda);
	}
	
	@Override
	public Vendas procurar (String id) 
			throws VendaNaoEncontradaException {
		Vendas retorno = null;
		if (this.venda != null) {
			if (this.venda.getId().equals(id)) retorno = this.venda;
			else retorno = this.proximo.procurar(id);
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
		return retorno;
	}

	@Override
	public boolean existe (String id) {
		if (this.venda != null) {
			if (this.venda.getId().equals(id)) {
				return true;
			} else return this.proximo.existe(id);
		} else return false;
	}

	@Override
	public void atualizar (Vendas venda) throws VendaNaoEncontradaException {
		if (this.venda != null && this.venda.getId().equals(venda.getId())) {
			this.venda = venda;
		}
		else if (this.venda == null) {
			VendaNaoEncontradaException v = new VendaNaoEncontradaException();
			throw v;
		}
		else {
			this.proximo.atualizar(venda);
		}
	}
}
