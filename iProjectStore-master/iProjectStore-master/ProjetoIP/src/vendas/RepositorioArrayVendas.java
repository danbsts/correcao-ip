package vendas;

import entregador.EntregadorNaoEncontradoException;

public class RepositorioArrayVendas implements VendasInterface {
	private int size = 0;
	private Vendas [] Repoa;
	
	public RepositorioArrayVendas() {
		Repoa=new Vendas[size];
	}

	public void VendaInserir(Vendas sale) throws ExisteVendaException{
		Vendas[] aux = new Vendas[size + 1];
		for (int i = 0; i <= size; i++) {
			if (i < size)
				aux[i] = Repoa[i];
			else if(i!=size&&Repoa[i].getSaleid().equals(sale.getSaleid())) {
				i=size+1;
				throw new ExisteVendaException();
			}
			else
				aux[i] = sale;
		}
		size++;
		Repoa = aux;
	}

	public void VendaRemover(String saleid) throws NaoExisteException{
		if(size==0) {
			throw new NaoExisteException();
		}
		Vendas[] aux = new Vendas[size - 1];
		boolean removeu = false;
		for (int i = 0; i < size; i++) {
			if((!removeu&&size==1&&!Repoa[i].getSaleid().equals(saleid))||(size!=1&&!removeu&&i==size-1&&!Repoa[i+1].getSaleid().equals(saleid))) {
				i++;
				throw new NaoExisteException();
				}
			else if (Repoa[i].getSaleid().equals(saleid)) {
				removeu=true;
				if(i+1!=size)
				aux[i] = Repoa[i+1];
				i++;
			}
			else
				aux[i] = Repoa[i];
		}
		size--;
		Repoa=aux;
	}
//(!removeu&&index==1&&!entregadores[i].getCpf().equals(cpf))||(index!=1&&!removeu&&i==index-1&&!entregadores[i+1].getCpf().equals(cpf))
	public void VendaAtualizar(Vendas sale) throws NaoExisteException {
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(sale.getSaleid())) {
				Repoa[i] = sale;
				i=size;
			}
			else if (i == size - 1)
				throw new NaoExisteException();
		}
	}

	public Vendas VendaProcurar(String saleid) throws NaoExisteException {
		Vendas sale = null;
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(saleid))
				sale = Repoa[i];
		}
		if (sale != null) {
			return sale;
		} else {
			throw new NaoExisteException();
		}
	}

	public boolean VendaExiste(String saleid) throws NaoExisteException {
		boolean aa = false;
		for (int i = 0; i < size; i++) {
			if (Repoa[i].getSaleid().equals(saleid))
				aa = true;
		}
		if (aa) {
			return aa;
		} else {
			throw new NaoExisteException();
		}
	}

}