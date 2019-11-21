package venda;


public class InserirExistenteException extends Exception {
private Venda venda;

public InserirExistenteException(Venda venda) {

	super ("N�o � possivel cadastrar uma venda igual a outra ja cadastrada, tente verificar o Id.");
	this.venda=venda;
}

public Venda getVenda() {
	return venda;
}


}
