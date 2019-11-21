package servicoDeEntrega;

public interface RepositorioServicoEntrega {
	
	void inserirFrete(ServicoDeEntrega frete);

	boolean existeFrete(int identificador);

	void removerFrete(int identificador) throws FreteInexistenteException;

	ServicoDeEntrega procurarFrete(int identificador) throws FreteInexistenteException;

	void atualizarFrete(int identificador, ServicoDeEntrega newFrete) throws FreteInexistenteException;

}
