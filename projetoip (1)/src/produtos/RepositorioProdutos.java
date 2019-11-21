package produtos;
public interface RepositorioProdutos {
	//Definir os metodos que os repositorios tem (cadastrar, remover, atualizar e procurar).
	public void inserir (Produto produto);
	public void remover(String nome) throws ProdutoNaoEncontradoException;
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException;
	public Produto procurar(String nome) throws ProdutoNaoEncontradoException;
	public boolean existe(String nome) ;
}
