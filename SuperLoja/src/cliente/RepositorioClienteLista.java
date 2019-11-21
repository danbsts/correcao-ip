package cliente;

public class RepositorioClienteLista implements RepositorioCliente {
	
	private RepositorioClienteLista prox;
	private Cliente cliente;

	public RepositorioClienteLista() {
		this.cliente = null;
		this.prox = null;
	}

	public void inserir(Cliente cliente) throws ClienteExisteException {
		if (this.cliente==null) {
			this.cliente = cliente;
			this.prox = new RepositorioClienteLista();
		} else if (this.cliente.equals(cliente)) {
			ClienteExisteException erro = new ClienteExisteException(cliente.getNome(),cliente.getCpf());
			throw erro;
			// cliente existe
		} else {
			this.prox.inserir(cliente);
		}

	}

	public Cliente buscar(String nome, String cpf) throws ClienteNExisteException {
			Cliente x=null;
			
		if (cliente.getNome().equals(nome) && cliente.getCpf().equals(cpf)) {
			x=cliente;
			return x;
		} else if (prox==null) {
			ClienteNExisteException erro = new ClienteNExisteException(nome,cpf);
			throw erro;
			// Nao existe esse cliente
		} else {
			return x = prox.buscar(nome, cpf);
		}
		
	}

	public boolean existe(String nome, String cpf) {
		 if (this.cliente == null) {
				return false;
			}
		else if (nome.equals(this.cliente.getNome())&&this.cliente.getCpf().equals(cpf)) {
			return true;
		}  else {
			return this.prox.existe(nome, cpf);

		}

	}

	public void atualizar(Cliente cliente, Cliente clienteNovo) throws ClienteNAtualizadoException {
		if (cliente.equals(this.cliente)) {
			this.cliente = clienteNovo;
		} else if (cliente==null) {
			ClienteNAtualizadoException erro = new ClienteNAtualizadoException(cliente);
			throw erro;
			// vai dar erro ou n atualizar no caso
		} else {
			this.prox.atualizar(cliente, clienteNovo);
		}
	}

	public void remover(Cliente cliente) throws ClienteNRemovidoException {
		if (cliente.equals(this.cliente)) {
			this.cliente = this.prox.cliente;
			this.prox = this.prox.prox;
		} else if (cliente==null) {
			ClienteNRemovidoException erro = new ClienteNRemovidoException(cliente);
			throw erro;
		} else {
			this.prox.remover(cliente);
		}

	}

}
