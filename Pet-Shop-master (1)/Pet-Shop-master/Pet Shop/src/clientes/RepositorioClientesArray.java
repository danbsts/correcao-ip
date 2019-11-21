package clientes;

import clientes.LimiteClientesAtingidoException;
import clientes.RepositorioClientes;
import clientes.ClienteNaoEncontradoException;
import clientes.Clientes;

public class RepositorioClientesArray implements RepositorioClientes {

	private Clientes[] arrayCliente;
	private int indice;

	public RepositorioClientesArray() {
		this.arrayCliente = new Clientes[500];
		this.indice = 0;
	}

	public Clientes procurar(String cpf) throws ClienteNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < 500; i ++) {
			if (this.arrayCliente[i]!=null && this.arrayCliente[i].getCpf().equals(cpf)) {
				achou = true;
				return this.arrayCliente[i];
			}
		}
		if (!achou) {
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
		return null;
	}

	public void inserir(Clientes cliente) throws LimiteClientesAtingidoException{
		if (this.indice < this.arrayCliente.length) {
			this.arrayCliente [indice] = cliente;
			indice ++;
		}
		else {
			LimiteClientesAtingidoException e = new LimiteClientesAtingidoException();
			throw e;
		}
	}

	public void remover(String cpf) throws ClienteNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < 500; i ++) {
			if (this.arrayCliente[i]!=null && this.arrayCliente[i].getCpf().equals(cpf)) {
				this.arrayCliente[i] = null;
				System.arraycopy(arrayCliente, i + 1, this.arrayCliente, i, this.arrayCliente.length - 1 - i);
				this.indice --;
				achou = true;
				return;
			}
		}
		if(!achou) {
			ClienteNaoEncontradoException e = new ClienteNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Clientes cliente) throws ClienteNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < 500; i ++) {
			if(this.arrayCliente[i]!=null && this.arrayCliente[i].getCpf().equals(cliente.getCpf())) {
				this.arrayCliente[i] = cliente;
				achou = true;
				return;
			}
		}
		if (!achou) {
			ClienteNaoEncontradoException a = new ClienteNaoEncontradoException();
			throw a;
		}
	}
	
	public boolean existe(String cpf) {
		for (int i = 0; i < 500; i ++) {
			if (this.arrayCliente[i]!=null && this.arrayCliente[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
}


