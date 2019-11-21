package venda;


public class VendaNaoEncontradaException extends Exception {
private Venda venda;

public VendaNaoEncontradaException(Venda venda) {

	super ("Nao foi poss�vel realizar opera��o, pois a venda n�o foi encontrada.");
	this.venda=venda;
}

public Venda getVenda() {
	return venda;
}


}
