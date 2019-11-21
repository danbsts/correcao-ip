package cliente;

public class CadastroCliente {
	private RepositorioCliente repositorio;

	public CadastroCliente(RepositorioCliente repositorioCliente) {
		this.repositorio = repositorioCliente;
	}
	
	

	public void cadastrar(Cliente cliente) throws ClienteExisteException, CamposInvalidoException {
		if (repositorio.existe(cliente.getNome(), cliente.getCpf())) {
			// cliente ja existe
			ClienteExisteException erro = new ClienteExisteException(cliente.getNome(), cliente.getCpf());
			throw erro;
		} else if (cliente.getNome().equals("") || cliente.getCpf().length() != 11) {
			CamposInvalidoException erro = new CamposInvalidoException();
			throw erro;
		} else {
			repositorio.inserir(cliente);
		}

	}

	public Cliente buscar(String nome, String cpf) throws ClienteNExisteException {
         
		return repositorio.buscar(nome, cpf);
	}

	public RepositorioCliente getRepositorio() {
		return repositorio;
	}



	public void setRepositorio(RepositorioCliente repositorio) {
		this.repositorio = repositorio;
	}



	public boolean existe(String nome, String cpf) {
		return repositorio.existe(nome, cpf);
	}

	public void remover(Cliente cliente) throws ClienteNRemovidoException {
		repositorio.remover(cliente);
	}

	public void atualizar(Cliente cliente, Cliente clienteNovo) throws ClienteNAtualizadoException {
		repositorio.atualizar(cliente, clienteNovo);
	}

}
