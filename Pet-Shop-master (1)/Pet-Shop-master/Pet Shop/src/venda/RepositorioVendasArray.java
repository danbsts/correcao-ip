package venda;

public class RepositorioVendasArray implements RepositorioVendas {

	private Vendas [] arrayVendas;
	private int indice;

	public RepositorioVendasArray () {
		this.arrayVendas = new Vendas [999];
		this.indice = 0;
	}

	@Override
	public void remover(String id) 
			throws VendaNaoEncontradaException {
		int a = this.getIndice(id);
		boolean achou4 = false;
		for (int i = 0; i < this.indice && !achou4; i++) {
			if (this.arrayVendas[i].getId().equals(id)) {
				achou4 = true;
			}
		}
		if (achou4) {
			if (this.arrayVendas.length - 1 - a >= 0) {
				//ocupando a posicao removida
				System.arraycopy(arrayVendas, a + 1, 
						this.arrayVendas, a, this.arrayVendas.length - 1 - a);
			}
			this.arrayVendas[this.arrayVendas.length - 1] = null;
			this.indice = this.indice - 1;
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
	}

	@Override
	//inserindo novas vendas
	public void inserir (Vendas venda) 
			throws LimiteAtingidoException {
		if (this.indice < this.arrayVendas.length) {
			this.arrayVendas[indice] = venda;
			indice++;
		} else {
			//indice > 999
			LimiteAtingidoException l;
			l = new LimiteAtingidoException();
			throw l;
		}
	}

	@Override
	public Vendas procurar (String id) 
			throws VendaNaoEncontradaException {
		Vendas retorno2 = null;
		boolean achou2 = false;
		for (int i = 0; i < this.indice && !achou2; i++) {
			if (this.arrayVendas[i].getId().equals(id)) {
				retorno2 = this.arrayVendas[i];
				achou2 = true;
			}
		}
		if(achou2) {
			return retorno2;
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
	}

	@Override
	public boolean existe (String id) {
		boolean achou3 = false;
		for (int i = 0; i < this.indice && !achou3; i++) {
			if (this.arrayVendas[i].getId().equals(id)) achou3 = true;
		}
		return achou3;
	}
	
	@Override
	public void atualizar(Vendas venda) 
			throws VendaNaoEncontradaException {
		int b = this.getIndice(venda.getId());
		arrayVendas [b] = venda;
	}

	public int getIndice(String id) 
			throws VendaNaoEncontradaException {
		int retorno = 0;
		boolean achou = false;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (this.arrayVendas[i].getId().equals(id)) {
				retorno = i;
				achou = true;
			}
		}
		if (achou) {
			return retorno;
		} else {
			VendaNaoEncontradaException v;
			v = new VendaNaoEncontradaException();
			throw v;
		}
	}
}
