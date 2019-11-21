package vendas;

public interface VendasInterface {
	public void VendaInserir(Vendas sale)
			throws ExisteVendaException;
			public void VendaAtualizar(Vendas sale)
			throws NaoExisteException;
			public void VendaRemover(String saleid)
			throws NaoExisteException;
			public Vendas VendaProcurar(String saleid)
			throws NaoExisteException;
			public boolean VendaExiste(String saleid)
			throws NaoExisteException;
}
