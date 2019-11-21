package entregador;

public interface RepositorioEntregadores {
	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException;

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException;

	public boolean verificarEntregador(String cpf);

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException;

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException;

}
