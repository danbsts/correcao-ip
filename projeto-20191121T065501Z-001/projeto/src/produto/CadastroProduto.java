package produto;

public class CadastroProduto {
	private RepositorioProduto produtos;
	private int cont;

	public CadastroProduto(RepositorioProduto repositorioProduto) {
		this.produtos = repositorioProduto;
	}

	public void CadastrarProduto(Produto produto) throws ProdutoJaExistenteException, ProdutoNaoAtualizadoException,
			NomeProdutoInvalidoException, ValorProdutoException, ValorDeCompraeVendaException, ProdutoVazioException, ProdutoInexistenteException {
		if (produto == null) {
			throw new ProdutoVazioException();
		} else if (produto.getNome_Produto().equals("")) {
			throw new NomeProdutoInvalidoException();

		} else if (produto.getValor() == 0) {
			throw new ValorProdutoException();

		} else if (produto.getValor_de_venda() == 0 || produto.getValor_de_Compra() == 0) {
			throw new ValorDeCompraeVendaException();
		} else if(produtos.existeProduto(produto.getNome_Produto())) {
			throw new ProdutoJaExistenteException();
		}
		else {
			produtos.cadastrarProduto(produto);
		}
	}

	public void RemoverProduto(String nomeproduto) throws ProdutoNaoRemovidoException, NomeProdutoInvalidoException,
			NomeProdutoInvalidoException, ProdutoInexistenteException {
		if (nomeproduto.equals("")) {
			throw new NomeProdutoInvalidoException();
		} else if (produtos.existeProduto(nomeproduto) == true) {

		} else {
			throw new ProdutoInexistenteException();
		}

	}

	public boolean ExisteProduto(String nomeproduto)
			throws ProdutoInexistenteException, ProdutoNaoEncontradoException, NomeProdutoInvalidoException {
		if (nomeproduto.equals("")) {
			throw new NomeProdutoInvalidoException();
		}
		if (produtos.existeProduto(nomeproduto) == true) {
			return true;
		} else {
			return false;
		}

	}

	public Produto ProcurarProduto(String nomeproduto)
			throws NomeProdutoInvalidoException, ProdutoNaoEncontradoException, ProdutoInexistenteException {
		if (nomeproduto.equals("")) {
			throw new NomeProdutoInvalidoException();
		}
		if (produtos.existeProduto(nomeproduto)) {
			return produtos.procurarProduto(nomeproduto);
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public void AtualizarProduto(Produto produto, String nomeproduto) throws NomeProdutoInvalidoException,
			ProdutoNaoEncontradoException, ProdutoInexistenteException, ProdutoNaoAtualizadoException {
		if (nomeproduto.contentEquals("")) {
			throw new NomeProdutoInvalidoException();
		}
		if (produtos.existeProduto(nomeproduto) == true) {
			produtos.atualizarProduto(produto, nomeproduto);
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

}
