package pessoas;
public class PessoaJaExistenteException extends Exception {
public PessoaJaExistenteException () {
	super ("Essa pessoa ja existe.");
}
}
