package clientes;

import clientes.RepositorioClientes;
import clientes.ClienteNaoEncontradoException;
import clientes.Clientes;

public class RepositorioClientesLista implements RepositorioClientes {

	private Clientes cliente;
	private RepositorioClientesLista proximo;

	public RepositorioClientesLista() {
		this.cliente = null;
		this.proximo = null;
	}

	public void inserir(Clientes cliente) {
		if (this.cliente == null) {
			this.cliente = cliente;
			this.proximo = new RepositorioClientesLista();
		} else {
			this.proximo.inserir(cliente);
		}
	}

	public void remover(String codigo) throws ClienteNaoEncontradoException {
		if (this.cliente != null && this.cliente.getCpf().equals(codigo)) {
			this.cliente = this.proximo.cliente;
			this.proximo = this.proximo.proximo;
		}
		else if (this.cliente == null) {
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		else {
			this.proximo.remover(codigo);
		}
	}

	public void atualizar(Clientes cliente) throws ClienteNaoEncontradoException {
		if (this.cliente != null && this.cliente.getCpf().equals(cliente.getCpf())) {
			this.cliente = cliente;
		}
		else if (this.cliente == null) {
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		else {
			this.proximo.atualizar(cliente);
		}
	}

	public Clientes procurar(String cpf) throws ClienteNaoEncontradoException {
		if (this.cliente != null && this.cliente.getCpf().equals(cpf)) {
			return this.cliente;
		}
		else if (this.cliente == null) {
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		else {
			return this.proximo.procurar(cpf);
		}

	}
	
	public boolean existe(String cpf) {
		if (this.cliente != null && this.cliente.getCpf().equals(cpf)) {
			return true;
		} else if (this.cliente == null) {
			return false;
		} else {
			return this.proximo.existe(cpf);
		}
	}
}
