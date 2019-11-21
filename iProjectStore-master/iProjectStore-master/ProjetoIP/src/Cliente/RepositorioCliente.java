package Cliente;
public interface RepositorioCliente {
	
	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException;
	
	public void remover(String cpf) throws ClienteNaoEncontradoException;
	
	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException;
        
	public boolean existe(String cpf);
	
	public void inserir(Cliente cliente); 
}