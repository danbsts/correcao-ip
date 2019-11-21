package Cliente;

public class CadastroCliente {

	private RepositorioCliente repositorio;
	
	public CadastroCliente(RepositorioCliente rep) {
		repositorio = rep;
	}

	 public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
	        if (!this.repositorio.existe(cliente.getCpf())) {
	            this.repositorio.inserir(cliente);
	        } else {
	            ClienteJaCadastradoException e;
	            e = new ClienteJaCadastradoException();
	            throw e;
	        }
	    }

	 public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
	        this.repositorio.atualizar(cliente);
	    }

	    public void remover(String cpf)
	            throws ClienteNaoEncontradoException {
	        this.repositorio.remover(cpf);
	    }

	    public Cliente procurar(String cpf)
	            throws ClienteNaoEncontradoException {
	        return this.repositorio.procurar(cpf);
	    }

	    public boolean existe(String cpf) {
	        return this.repositorio.existe(cpf);
	        	
	    }
	    public void inserir(Cliente cliente) {
	    	this.repositorio.inserir(cliente);
	    }

}
