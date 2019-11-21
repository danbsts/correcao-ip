package produtos;

public class teste {

	public static void main(String[] args) throws LimiteProdutosAtingidoException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException{
		// TODO Auto-generated method stub
		RepositorioProduto repoTeste = new RepositorioProdutosLista();
		Produtos teste = new Produtos("pingulinho", "454", 22, 2, "thiago ventura");
		Produtos teste1 = new Produtos("sapinho", "69", 1.5 , 3 , "biel");
		Produtos teste2 = new Produtos("coutola", "666", 50 , 8000 , "matuses lemonade");
		repoTeste.inserir(teste);
		repoTeste.inserir(teste1);
		repoTeste.inserir(teste2);
		repoTeste.remover("69");
		System.out.println(repoTeste.existe("69"));
	}

}
