package pacoteExcecoes;

public class NDException extends Exception{
	public NDException () {
		super ("Demanda não cadastrada, favor cadastrar a Demanda em nosso site.");
	}
}
