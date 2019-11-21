package produtos;
public class RepositorioProdutosLista implements RepositorioProdutos{

	private Produto produto;
	private RepositorioProdutosLista prox;

	public RepositorioProdutosLista() {

		this.produto = null;
		this.prox = null;
	}

	//Metodo para inserir novos produtos.
	public void inserir (Produto produto) {

		if(this.produto == null) {
			this.produto = produto;
			this.prox = new RepositorioProdutosLista();
		}
		else {
			this.prox.inserir(produto);
		}
	}

	//Metodo para remover produtos.
	public void remover(String nome) throws ProdutoNaoEncontradoException{

		if(this.produto == null) {
			throw new ProdutoNaoEncontradoException(nome);
		}
		else {
			if(this.produto.getNome().equals(nome)) {
				this.produto = this.prox.produto;
				this.prox = this.prox.prox;
			}
			else {
				this.prox.remover(nome);
			}

		}
	}

	//Metodo para atualizar produtos.
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {

		if(this.produto == null) {
			throw new ProdutoNaoEncontradoException(produto.getNome());

		}
		else if(this.produto.getNome().equals(produto.getNome())) {
			this.produto = produto;

		}
		else {
			this.prox.atualizar(produto);
		}
	}

	//Metodo para procurar por produtos.
	public Produto procurar(String nome) throws ProdutoNaoEncontradoException {

		if(this.produto == null) {
			throw new ProdutoNaoEncontradoException(nome);

		}
		else {
			if(this.produto.getNome().equals(nome)) {

				return this.produto;
			}
			else {
				return this.prox.procurar(nome);
			}
		}
	}

	//Metodo para checar a existencia de produtos.
	public boolean existe(String nome) {

		if(this.produto == null) {
			return false;
		}
		else {
			if(this.produto.getNome().equals(nome)) {
				return true;

			}
			else {
				return this.prox.existe(nome);
			}
		}
	}
}
