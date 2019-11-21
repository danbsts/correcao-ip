package vendas;

public class CadastroVendas {
	private VendasInterface vendas;

	public CadastroVendas(VendasInterface repo) {
		vendas = repo;
	}

	public void VendaInserir(Vendas sale) throws ExisteVendaException {
		this.vendas.VendaInserir(sale);
	}

	public void VendaRemover(String id) throws NaoExisteException {
		this.vendas.VendaRemover(id);
	}

	public boolean VendaExiste(String id) throws NaoExisteException {
		return this.vendas.VendaExiste(id);
	}

	public void VendaAtualizar(Vendas sale) throws NaoExisteException {
		this.vendas.VendaAtualizar(sale);
	}

	public Vendas VendaProcurar(String id) throws NaoExisteException {
		return this.vendas.VendaProcurar(id);
	}
}
