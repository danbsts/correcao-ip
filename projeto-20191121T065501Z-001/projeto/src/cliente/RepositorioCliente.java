package cliente;

public interface RepositorioCliente {
	public void inserir(Cliente cliente) throws ClienteExisteException;

	public Cliente buscar(String nome, String cpf) throws ClienteNExisteException;

	public boolean existe(String nome, String cpf);

	public void atualizar(Cliente cliente, Cliente clienteNovo) throws ClienteNAtualizadoException;

	public void remover(Cliente cliente) throws ClienteNRemovidoException;

}
