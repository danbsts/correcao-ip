package mercadoria;

public class CadastroMercadorias {
	private RepositorioMercadoria repositorio;
	
	public CadastroMercadorias (RepositorioMercadoria repo) {
		repositorio = repo;
	}
	
	public void cadastrar (Mercadoria mercadoria) throws MercadoriaJaCadastradaException{
		if (!this.repositorio.existe(mercadoria.getId())) {
			this.repositorio.inserir(mercadoria);
		} else {
			MercadoriaJaCadastradaException e;
			e = new MercadoriaJaCadastradaException();
			throw e;
		}
	}
	
	public void remover (int id) throws MercadoriaNaoEncontradaException {
		this.repositorio.remover(id);
	}
	
	public boolean existe (int id) {
		return this.repositorio.existe(id);
	}
	
	public void atualizar (Mercadoria mercadoria) throws MercadoriaNaoEncontradaException {
		this.repositorio.atualizar(mercadoria);
	}
	
	public Mercadoria procurar (int id) throws MercadoriaNaoEncontradaException {
		return this.repositorio.procurar(id);
	}

	

}