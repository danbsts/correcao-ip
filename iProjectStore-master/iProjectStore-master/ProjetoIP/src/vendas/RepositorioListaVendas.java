package vendas;

import entregador.EntregadorNaoEncontradoException;

public class RepositorioListaVendas implements VendasInterface{
	private Vendas sale;
	private RepositorioListaVendas next;

	public RepositorioListaVendas() {
		this.sale = null;
		this.next = null;
	}

	public RepositorioListaVendas(Vendas sale) {
		this.sale = sale;
		this.next = null;
	}

	public void VendaInserir(Vendas sale) throws ExisteVendaException {
		if (this.sale == null) {
			this.sale = sale;
			this.next = new RepositorioListaVendas();
		} else if (this.sale.getSaleid().equals(sale.getSaleid())) {
			throw new ExisteVendaException();
		} else {
			this.next.VendaInserir(sale);
		}
	}
	public void VendaRemover(String saleid) throws NaoExisteException{
		if (this.sale != null) {
			this.sale = this.next.sale;
			this.next = this.next.next;
		} else {
			throw new NaoExisteException();
		}
	}
	public boolean VendaExiste(String saleid) throws NaoExisteException{
		if(this.sale!=null&&saleid==this.sale.getSaleid()) {
			return true;
		}
		else if(this.next==null) {
			throw new NaoExisteException();
		}
		else {
			return this.next.VendaExiste(saleid);
		}
	}
	public Vendas VendaProcurar(String saleid) throws NaoExisteException{
		if(this.sale!=null&&this.sale.getSaleid().equals(saleid)) {
			return sale;
		}
		else if(this.next==null)
			throw new NaoExisteException();
		else {
			return this.next.VendaProcurar(saleid);
		}
	}
	public void VendaAtualizar(Vendas sale) throws NaoExisteException{
		if(this.sale!=null&&this.sale.getSaleid().equals(sale.getSaleid())) {
			this.sale=sale;
		}
		else if(this.next!=null) {
			this.next.VendaAtualizar(sale);
		}
		else {
			throw new NaoExisteException();	
		}
	}


}
