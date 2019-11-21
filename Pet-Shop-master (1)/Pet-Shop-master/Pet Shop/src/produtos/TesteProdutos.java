package produtos;
 
public class TesteProdutos {
	public static void main(String[] args) throws ProdutoNaoEncontradoException, ProdutoJaCadastradoException, LimiteProdutosAtingidoException{
		//RepositorioProduto repoteste = new RepositorioProdutosArray ();
		RepositorioProduto repoteste = new RepositorioProdutosLista ();
		Produtos teste1 = new Produtos("Ração", "F-666", 34.5, 70, "João da carne de sol");
		Produtos teste2 = new Produtos("Nsei", "F-645", 9.5, 70, "João da carne de sol");
		Produtos teste3 = new Produtos("carambolas", "F-269", 394.5, 70, "João da carne de sol");
		repoteste.inserir(teste3);
		repoteste.inserir(teste1);
		repoteste.inserir(teste2);
		System.out.println(repoteste.existe("F-666"));
		repoteste.remover("F-666");
		System.out.println(repoteste.existe("F-666"));
		System.out.println(repoteste.procurar("F-269"));
		repoteste.remover("F-269");
		System.out.println(repoteste.procurar("F-269"));
	}
}
