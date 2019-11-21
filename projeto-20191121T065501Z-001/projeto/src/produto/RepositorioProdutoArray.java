package produto;

public class RepositorioProdutoArray implements RepositorioProduto {
	private Produto[] produtos;
	private int indice;
	private int quantidade;
	private boolean removido, existe, atualizar;

	public void RepositorioprodutosArray() {
		this.produtos = new Produto[30];
		indice = 0;
		quantidade=30;
	}

	public void cadastrarProduto(Produto produto) {
		if (indice <= produtos.length) {
			produtos[indice] = produto;
			indice++;
		} else {
			Produto[] aux = new Produto[produtos.length];
			aux = produtos;
			produtos = new Produto[produtos.length * 2];
			produtos = aux;
			quantidade = produtos.length;
		}
	}

	@Override
	public void removerProduto(String nomeproduto) throws ProdutoNaoRemovidoException {
		for (int i = 0; i < quantidade; i++) {
			if (produtos[i].equalsProduto(nomeproduto)) {
				produtos[i] = null;
				boolean removido = true;
			}
		}
		if (removido = true) {		
	} else {
			throw new ProdutoNaoRemovidoException();
		}
	}

	@Override
	public boolean existeProduto(String nomeproduto) throws ProdutoInexistenteException {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i]!=null) {
				if (produtos[i].getNome_Produto().equals(nomeproduto)) {
					existe = true;
				}
			}
			
		}
		return existe;

	}

	public Produto procurarProduto(String nomeproduto) throws ProdutoNaoEncontradoException {
		Produto aux = null;
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].equalsProduto(nomeproduto))
				;
			aux = produtos[i];
		}
		if (aux == null) {
			throw new ProdutoNaoEncontradoException();
		} else {
			return aux;
		}

	}

	public void atualizarProduto(Produto newproduto, String nomedoproduto) throws ProdutoNaoAtualizadoException {

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].equalsProduto(nomedoproduto)) {
				produtos[i] = newproduto;
				atualizar = true;
			}
		}
		if (atualizar == true) {
			throw new ProdutoNaoAtualizadoException();
		}
	}

}
