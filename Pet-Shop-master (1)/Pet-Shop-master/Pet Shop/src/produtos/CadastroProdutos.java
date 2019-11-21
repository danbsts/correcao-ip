package produtos;

public class CadastroProdutos {
	private RepositorioProduto repositorio;
	public CadastroProdutos(RepositorioProduto repositorio) {
		this.repositorio = repositorio;
	}

	public void cadastrar(Produtos produto) throws LimiteProdutosAtingidoException, ProdutoNaoEncontradoException, ProdutoJaCadastradoException{ 
		if(!this.repositorio.existe(produto.getCode())) {
			this.repositorio.inserir(produto);
		} else {
			ProdutoJaCadastradoException p;
			p = new ProdutoJaCadastradoException();
			throw p;
		}
	}

	public void atualizarProduto (Produtos produto) throws ProdutoNaoEncontradoException {
		this.repositorio.atualizarProduto(produto);
	}
	public void remover(String codeProduto) throws ProdutoNaoEncontradoException {
		this.repositorio.remover(codeProduto);
	}

	public Produtos procurar(String codeProduto)throws ProdutoNaoEncontradoException {
		return this.repositorio.procurar(codeProduto);
	}
	
	public boolean existe(String codeProduto) {
		return this.repositorio.existe(codeProduto);
	}
	
}

