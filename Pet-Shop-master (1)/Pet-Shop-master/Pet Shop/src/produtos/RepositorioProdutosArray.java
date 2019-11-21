package produtos;

public class RepositorioProdutosArray implements RepositorioProduto {
	private Produtos[] arrayProdutos;
	private int indice;

	public RepositorioProdutosArray() {
		this.arrayProdutos = new Produtos [100];
		this.indice = 0;
	}

	@Override
	public void inserir(Produtos produto) throws LimiteProdutosAtingidoException{ 
		if(this.indice < this.arrayProdutos.length) {
			this.arrayProdutos[this.indice] = produto;
			this.indice++;
		} else {
			LimiteProdutosAtingidoException p;
			p = new LimiteProdutosAtingidoException();
			throw p;
		}
	}

	@Override
	public Produtos procurar(String codeProduto) throws ProdutoNaoEncontradoException {
		Produtos p = null;
		boolean find = false;
		for(int i=0; i<indice && !find; i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				find = true;
				p = this.arrayProdutos[i];
			} else {
				p = null;
			}
		} if (p==null) {
			ProdutoNaoEncontradoException x;
			x = new ProdutoNaoEncontradoException();
			throw x;
		} else {
			return p;
		}
	}

	@Override
	public void remover(String codeProduto) throws ProdutoNaoEncontradoException {
		boolean removido = false;
		for (int i=0; i<indice && !removido; i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				this.arrayProdutos[i] = null;
				System.arraycopy(arrayProdutos, i+1, this.arrayProdutos, i, this.arrayProdutos.length -1 -i);
				indice -= 1;
				removido = true;
			}
		}
		if (!removido) {
			ProdutoNaoEncontradoException p;
			p = new ProdutoNaoEncontradoException();
			throw p;
		}
	}

	@Override
	public boolean existe(String codeProduto){
		for (int i=0; i<indice;i++) {
			if (this.arrayProdutos[i].getCode().equals(codeProduto)) {
				return true;
			}
		} 
		return false;
	}

	@Override
	public void atualizarProduto(Produtos produto) throws ProdutoNaoEncontradoException {
		boolean atualizado = false;
		for (int i=0; i<this.arrayProdutos.length && !atualizado;i++) {
			if (this.arrayProdutos[i].getCode().equals(produto.getCode())) {
				atualizado = true;
				this.arrayProdutos[i]=produto;
			}
		}
		if (!atualizado) {
			ProdutoNaoEncontradoException p = new ProdutoNaoEncontradoException();
			throw p;
		}
	}


}
