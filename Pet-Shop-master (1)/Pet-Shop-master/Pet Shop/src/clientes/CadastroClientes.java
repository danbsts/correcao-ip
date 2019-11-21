package clientes;

public class CadastroClientes {
	private RepositorioClientes repocliente;
	
	public CadastroClientes (RepositorioClientes repocliente) {
		this.repocliente = repocliente;
	}
	
	public void cadastrar (Clientes cliente) throws ClienteJaCadastradoException, LimiteClientesAtingidoException {
		if(!this.repocliente.existe(cliente.getCpf())) {
			this.repocliente.inserir(cliente);
		} else {
			ClienteJaCadastradoException e = new ClienteJaCadastradoException();
			throw e;
		}
	}
	
	public void remover (String cpf) throws ClienteNaoEncontradoException{
		this.repocliente.remover(cpf);
	}
	
	public void atualizar (Clientes cliente) throws ClienteNaoEncontradoException{
		this.repocliente.atualizar(cliente);
	}
	
	public Clientes procurar (String cpf) throws ClienteNaoEncontradoException{
		return this.repocliente.procurar(cpf);
	}
	
	public boolean existe (String cpf) {
		return this.repocliente.existe(cpf);
	}	
}
