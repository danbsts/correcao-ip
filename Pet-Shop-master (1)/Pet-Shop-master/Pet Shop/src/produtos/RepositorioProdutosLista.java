package produtos;

public class RepositorioProdutosLista implements RepositorioProduto{
	private Produtos produto;
	private RepositorioProdutosLista next;

	public RepositorioProdutosLista() {
		this.produto=null;
		this.next=null;
	}

	@Override
	public void inserir(Produtos produto) throws ProdutoJaCadastradoException {
		if (this.produto==null) {
			this.produto = produto;
			this.next = new RepositorioProdutosLista();
		} else if (this.produto.getCode().equals(produto.getCode())) {
			ProdutoJaCadastradoException p;
			p = new ProdutoJaCadastradoException();
			throw p;
		}
		else {
			this.next.inserir(produto);
		}
	}

	@Override
	public Produtos procurar(String codeProduto) throws ProdutoNaoEncontradoException {
		Produtos p = null;
		if (this.produto!=null&&this.produto.getCode().equals(codeProduto)) {
			p = this.produto;
		} else if (this.produto==null) {
			ProdutoNaoEncontradoException x;
			x = new ProdutoNaoEncontradoException();
			throw x;		
		} else {
			this.next.procurar(codeProduto);
		}
		return p;
	}

	@Override
	public void remover(String codeProduto) throws ProdutoNaoEncontradoException{
		if (this.produto!=null && this.produto.getCode().equals(codeProduto)) {
			this.produto=this.next.produto;
			this.next=this.next.next;
		} else if (this.produto==null) {
			ProdutoNaoEncontradoException x;
			x = new ProdutoNaoEncontradoException();
			throw x;	
		} else {
			this.next.remover(codeProduto);
		}
	}

	@Override
	public boolean existe(String codeProduto){
		if (this.produto!=null&&this.produto.getCode().equals(codeProduto)) {
			return true;
		} else if (this.produto==null) {
			return false;
		} else {
			return this.next.existe(codeProduto);
		}
	}

	@Override
	public void atualizarProduto(Produtos produto) throws ProdutoNaoEncontradoException{
		if (this.produto.getCode().equals(this.produto.getCode())&&this.produto!=null) {
			this.produto = produto;
		} else if (this.produto==null) {
			ProdutoNaoEncontradoException x;
			x = new ProdutoNaoEncontradoException();
			throw x;
		} else {
			this.next.atualizarProduto(produto);
		}
	}

}
