package produtos;

public class ProdutoJaCadastradoException extends Exception{

	private String nome;

	//Erro para o caso em que tente ser inserido um produto que ja exista.
	public ProdutoJaCadastradoException (String nome){
		super ("Produto ja cadastrado.");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
