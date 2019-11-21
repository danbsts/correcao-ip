package pessoas;


	public class PessoaNaoEncontradaException extends Exception {
		public PessoaNaoEncontradaException () {
			super ("Essa pessoa nao foi encontrada.");
	}

		public PessoaNaoEncontradaException(String nome) {
			super (nome+" nao foi encontrado(a).");
		}


}
