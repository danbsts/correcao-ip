package venda;


public class BuscaIdException extends Exception {
private int id;

public BuscaIdException(int id) {

	super ("Nenhuma venda com esse c�digo foi encontrada");
	this.id=id;
}

public int getId() {
	return id;
}


}