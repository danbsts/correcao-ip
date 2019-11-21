package produto;

public class RepositorioProdutosLista implements RepositorioProduto {

	private Produto produto;
	private RepositorioProdutosLista proximo;
	public RepositorioProdutosLista() {
		this.produto = null;
		this.proximo = null;
	}

	public Produto getProduto() {
		return produto;
	}

	public RepositorioProdutosLista getProximo() {
		return proximo;
	}

	public void cadastrarProduto(Produto produto) {
		if (this.produto == null) {
			this.produto = produto;
			this.proximo = new RepositorioProdutosLista();
		} else {
			this.proximo.cadastrarProduto(produto);
		}
	}

	public void removerProduto(String nomeproduto) throws ProdutoNaoRemovidoException {
		if (this.produto!=null) {
			if (this.produto.getNome_Produto().equals(nomeproduto)) {
				this.produto = this.proximo.produto;
				this.proximo = this.proximo.proximo;				
			}
		}
		 else {
			 this.proximo.removerProduto(nomeproduto);
		}

	}

	public Produto procurarProduto(String nomeproduto) throws ProdutoNaoEncontradoException {
		 if (this.produto.getNome_Produto().equals(nomeproduto)) {
			return this.produto;
		} else {
			return this.proximo.procurarProduto(nomeproduto);
		}
	}

	public void atualizarProduto(Produto newproduto, String nomedoproduto) throws ProdutoNaoAtualizadoException {
		// TODO Auto-generated method stub
		if (this.produto != null) {
			if ( this.produto.getNome_Produto().equals(nomedoproduto)) {
				this.produto = newproduto;
			} else {
				this.proximo.atualizarProduto(newproduto, nomedoproduto);
			}
		} else {
			throw new ProdutoNaoAtualizadoException();
		}
	}

	@Override
	public boolean existeProduto(String nomedoproduto) throws ProdutoInexistenteException {
		boolean existeProduto = false;
		if (this.produto != null) {
			if (this.produto.getNome_Produto().equals(nomedoproduto)) {
				existeProduto = true;
			} else {
				this.proximo.existeProduto(nomedoproduto);
			}
		}
		return existeProduto;
	}

}