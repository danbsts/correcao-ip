package pessoas;
public class CpfInvalidoException extends Exception {
public CpfInvalidoException () {
	super ("Esse cpf n�o parece adequado.");
}
}
