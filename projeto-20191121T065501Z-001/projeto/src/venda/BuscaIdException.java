package venda;


public class BuscaIdException extends Exception {
private int id;

public BuscaIdException(int id) {

	super ("Nenhuma venda com esse código foi encontrada");
	this.id=id;
}

public int getId() {
	return id;
}


}