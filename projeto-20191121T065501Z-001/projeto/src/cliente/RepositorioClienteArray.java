package cliente;


public class RepositorioClienteArray implements RepositorioCliente {

	private Cliente repositorioA[];
	private int num;
	
	public RepositorioClienteArray () {
		this.repositorioA = new Cliente[30];
		this.num=0;
	}

	public void inserir(Cliente cliente) throws ClienteExisteException {
		if (num >= repositorioA.length) {

			Cliente[] aux = new Cliente[repositorioA.length * 2];
			for (int i = 0; i < repositorioA.length; i++) {
				aux[i] = repositorioA[i];
			}
			this.repositorioA = aux;
			inserir(cliente);
		} else {
			repositorioA[num] = cliente;
			num++;
		}

			
		

	}

	public Cliente buscar(String nome, String cpf) throws ClienteNExisteException {
		Cliente aux = null;
		for (int i = 0; i < repositorioA.length; i++) {
			if (repositorioA[i].getNome().equals(nome) && repositorioA[i].getCpf().equals(cpf)) {
				aux = repositorioA[i];
				return aux;
			}
		}
		if (aux==null) {
			ClienteNExisteException erro = new ClienteNExisteException(nome, cpf);
			throw erro;
		}
		return aux;
	}

	public boolean existe(String nome, String cpf) {
		boolean aux = false;
		for (int i = 0; i < repositorioA.length; i++) {
			if (repositorioA[i]!=null) {
				if ((repositorioA[i].getNome().equals(nome)&&repositorioA[i].getCpf().equals(cpf))) {
					aux = true;

				} else {

				}
			}
		
		}

		return aux;
	}

	public void atualizar(Cliente cliente, Cliente clienteNovo) throws ClienteNAtualizadoException {
		for (int i = 0; i < repositorioA.length; i++) {
			if (cliente.equals(repositorioA[i])) {
				repositorioA[i] = clienteNovo;
				break;
			} else if (cliente==null) {
				ClienteNAtualizadoException erro = new ClienteNAtualizadoException(cliente);
				throw erro;
			}
		}

	}

	public void remover(Cliente cliente) throws ClienteNRemovidoException {
		int contador=0;
		for (contador=0; contador < repositorioA.length; contador++) {
			if(cliente==null) {
				break;
			}
			else {
				
			}
		}
		for (int i = 0; i < repositorioA.length; i++) {
			if (cliente.equals(repositorioA[i])) {
		      repositorioA[i]= repositorioA[contador-1];
              repositorioA[contador-1]=null;
              break;
			}
			else if(i==repositorioA.length-1) {
				ClienteNRemovidoException erro = new ClienteNRemovidoException(cliente);
				throw erro;
			}
		}

	}
}