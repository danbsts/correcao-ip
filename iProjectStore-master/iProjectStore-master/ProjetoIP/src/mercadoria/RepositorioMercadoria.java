package mercadoria;

public interface RepositorioMercadoria {
	public void inserir(Mercadoria mercadoria)
			throws MercadoriaJaCadastradaException;

	public void remover(int id)
			throws MercadoriaNaoEncontradaException;

	public boolean existe(int id);

	public void atualizar(Mercadoria mercadoria)
			throws MercadoriaNaoEncontradaException;
	
	public Mercadoria procurar(int id)
			throws MercadoriaNaoEncontradaException;

}
