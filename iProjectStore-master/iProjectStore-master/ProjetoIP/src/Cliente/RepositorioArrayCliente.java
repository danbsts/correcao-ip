package Cliente;



public class RepositorioArrayCliente implements RepositorioCliente {

	private Cliente[] arrayClientes;
	private int index;

	public RepositorioArrayCliente() {
		this.index = 0;
		this.arrayClientes = new Cliente[index];

	}

	public void inserir(Cliente cliente){
		Cliente[] aux = new Cliente[index + 1];
		for (int i = 0; i <= index; i++) {
			if (i < index)
				aux[i] = arrayClientes[i];
			else
				aux[i] = cliente;
		}
		index++;
		arrayClientes = aux;
	}


	public void remover(String cpf) throws ClienteNaoEncontradoException {
		int index = this.getIndice(cpf);

		if (this.arrayClientes.length - 1 - index >= 0) {
			System.arraycopy(arrayClientes, index + 1, this.arrayClientes, index,
					this.arrayClientes.length - 1 - index);
		}
		this.arrayClientes[this.arrayClientes.length - 1] = null;
		this.index = this.index - 1;
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		Cliente retorno = null;
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayClientes[i].getCpf().equals(cpf)) {
				retorno = this.arrayClientes[i];
				achou = true;
			}
		}
		if (achou) {
			return retorno;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		int index = this.getIndice(cliente.getCpf());
		arrayClientes[index] = cliente;
	}

	public boolean existe(String cpf) {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayClientes[i].getCpf().equals(cpf)) {
				achou = true;
			}
		}
		return achou;
	}

	private int getIndice(String cpf) throws ClienteNaoEncontradoException {
		int retorno = 0;
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayClientes[i].getCpf().equals(cpf)) {
				retorno = i;
				achou = true;
			}
		}
		if (achou) {
			return retorno;
		} else {
			ClienteNaoEncontradoException e;
			e = new ClienteNaoEncontradoException();
			throw e;
		}
	}
}
