package venda;


public class VendaNaoEncontradaException extends Exception {
private Venda venda;

public VendaNaoEncontradaException(Venda venda) {

	super ("Nao foi possível realizar operação, pois a venda não foi encontrada.");
	this.venda=venda;
}

public Venda getVenda() {
	return venda;
}


}
